
package com.example.demoLibraryProject.repository;

import com.example.demoLibraryProject.model.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Member> memberRowMapper = new RowMapper<>() {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setPhone(rs.getString("phone"));
            member.setRegisteredDate(rs.getDate("registered_date").toLocalDate());
            return member;
        }
    };

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM members";
        return this.jdbcTemplate.query(sql, this.memberRowMapper);
    }

    public Optional<Member> findById(Long id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        List<Member> list = this.jdbcTemplate.query(sql, this.memberRowMapper, new Object[]{id});
        return list.stream().findFirst();
    }

    public Long save(Member member) {
        String sql = "INSERT INTO members (name, phone, registered_date) VALUES (?, ?, ?) RETURNING id";
        return (Long)this.jdbcTemplate.queryForObject(sql, new Object[]{member.getName(), member.getPhone(), member.getRegisteredDate()}, Long.class);
    }

    public int update(Long id, Member member) {
        String sql = "UPDATE members SET name = ?, phone = ?, registered_date = ? WHERE id = ?";
        return this.jdbcTemplate.update(sql, new Object[]{member.getName(), member.getPhone(), member.getRegisteredDate(), id});
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM members WHERE id = ?";
        return this.jdbcTemplate.update(sql, new Object[]{id});
    }
}
