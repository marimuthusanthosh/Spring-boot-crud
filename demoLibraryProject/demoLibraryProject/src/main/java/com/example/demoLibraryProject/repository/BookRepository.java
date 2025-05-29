package com.example.demoLibraryProject.repository;

import com.example.demoLibraryProject.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> bookMapper = (rs, rowNum) -> {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublishedDate(rs.getDate("published_date").toLocalDate());
        book.setAvailableCopies(rs.getInt("available_copies"));
        return book;
    };

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM book", this.bookMapper);
    }

    public Optional<Book> findById(Long id) {
        List<Book> result = this.jdbcTemplate.query("SELECT * FROM book WHERE id = ?", this.bookMapper, new Object[]{id});
        return result.stream().findFirst();
    }

    public Long save(Book book) {
       return (long) this.jdbcTemplate.update("INSERT INTO book (title, author, isbn, published_date, available_copies) VALUES (?, ?, ?, ?, ?)", new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishedDate(), book.getAvailableCopies()});

    }

    public void update(Long id, Book book) {
        this.jdbcTemplate.update("UPDATE book SET title = ?, author = ?, isbn = ?, published_date = ?, available_copies = ? WHERE id = ?", new Object[]{book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishedDate(), book.getAvailableCopies(), id});
    }

    public void delete(Long id) {
        this.jdbcTemplate.update("DELETE FROM book WHERE id = ?", new Object[]{id});
    }

    public List<Book> search(String keyword) {
        String q = "%" + keyword.toLowerCase() + "%";
        return this.jdbcTemplate.query("SELECT * FROM book WHERE LOWER(title) LIKE ? OR LOWER(author) LIKE ? OR isbn LIKE ?", this.bookMapper, new Object[]{q, q, q});
    }
}
