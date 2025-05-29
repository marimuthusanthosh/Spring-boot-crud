package com.example.demoLibraryProject.repository;

import com.example.demoLibraryProject.model.Book;
import com.example.demoLibraryProject.model.Borrow;
import com.example.demoLibraryProject.model.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowRepository {
    private final JdbcTemplate jdbcTemplate;

    public BorrowRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Borrow> findAll() {
        String sql = "    SELECT b.id, b.member_id, b.book_id, b.borrowed_date, b.due_date,\n           m.id AS m_id, m.name, m.phone, m.registered_date,\n           bk.id AS bk_id, bk.title, bk.author, bk.isbn, bk.published_date, bk.available_copies\n    FROM borrows b\n    JOIN members m ON b.member_id = m.id\n    JOIN book bk ON b.book_id = bk.id\n";
        return this.jdbcTemplate.query(sql, (rs, rowNum) -> {
            return this.mapBorrow(rs);
        });
    }

    public Borrow findById(Long id) {
        String sql = "    SELECT b.id, b.member_id, b.book_id, b.borrowed_date, b.due_date,\n        m.id AS m_id, m.name, m.phone, m.registered_date,\n           bk.id AS bk_id, bk.title, bk.author, bk.isbn, bk.published_date, bk.available_copies\n    FROM borrows b\n    JOIN members m ON b.member_id = m.id\n    JOIN book bk ON b.book_id = bk.id\n    WHERE b.id = ?\n";
        return (Borrow)this.jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return this.mapBorrow(rs);
        }, new Object[]{id});
    }

    public void save(Borrow borrow) {
        String sql = "INSERT INTO borrows (member_id, book_id, borrowed_date, due_date) VALUES (?, ?, ?, ?)";
        this.jdbcTemplate.update(sql, new Object[]{borrow.getMemberId(), borrow.getBookId(), borrow.getBorrowedDate(), borrow.getDueDate()});
        this.jdbcTemplate.update("UPDATE book SET available_copies = available_copies - 1 WHERE id = ? AND available_copies > 0", new Object[]{borrow.getBookId()});
    }

    public void returnBook(Long borrowId) {
        Borrow borrow = this.findById(borrowId);
        this.jdbcTemplate.update("UPDATE books SET available_copies = available_copies + 1 WHERE id = ?", new Object[]{borrow.getBookId()});
        this.jdbcTemplate.update("DELETE FROM borrows WHERE id = ?", new Object[]{borrowId});
    }

    private Borrow mapBorrow(ResultSet rs) throws SQLException {
        Borrow borrow = new Borrow();
        borrow.setId(rs.getLong("id"));
        borrow.setMemberId(rs.getLong("member_id"));
        borrow.setBookId(rs.getLong("book_id"));
        borrow.setBorrowedDate(rs.getDate("borrowed_date").toLocalDate());
        borrow.setDueDate(rs.getDate("due_date").toLocalDate());
        Member member = new Member();
        member.setId(rs.getLong("m_id"));
        member.setName(rs.getString("name"));
        member.setPhone(rs.getString("phone"));
        member.setRegisteredDate(rs.getDate("registered_date").toLocalDate());
        Book book = new Book();
        book.setId(rs.getLong("bk_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishedDate(rs.getDate("published_date").toLocalDate());
        book.setAvailableCopies(rs.getInt("available_copies"));
        borrow.setBook(book);
        borrow.setMember(member);
        return borrow;
    }
}
