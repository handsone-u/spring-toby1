package com.spring1.toby1.ch3;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class AddStatement implements StatementStrategy{
    User user;

    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement
                ("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        return ps;
    }
}
