package com.spring1.toby1.ch3;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class UserDaoV4 {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void add(User user) {
        jdbcTemplate.update("insert into USERS(id, name, password) VALUES ( ?.?,? )",
                user.getId(), user.getName(), user.getPassword());
    }

    public void deleteAll() {
        jdbcTemplate.update("delete from USERS");
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("select count(*) from USERS", Integer.class);
    }

    public User get(String id) {
        return jdbcTemplate.queryForObject("select * from USERS where id = ?",
                new Object[]{id},
                getRowMapper());
    }

    public List<User> getAll() {
        return jdbcTemplate.query("select * from users order by id",
                getRowMapper());
    }

    private RowMapper<User> getRowMapper() {
        return new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("password"));
            }
        };
    }
}
