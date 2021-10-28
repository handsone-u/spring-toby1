package com.spring1.toby1.ch3;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Setter @NoArgsConstructor
public class UserDaoV3 {
    private JdbcContext jdbcContext;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcContext.setDataSource(dataSource);
    }

    public void add(final User user) throws SQLException {
        class AddStatement implements StatementStrategy{
            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement
                        ("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");

                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                return ps;
            }
        }
        jdbcContext.workWithStatementStrategy(new AddStatement());
    }

    public void deleteAll() throws SQLException {
        jdbcContext.executeSql("delete from USERS");
    }
}
