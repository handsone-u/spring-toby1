package com.spring1.toby1.ch3;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoV1DeleteAll extends AbstractUserDao{
    @Override
    protected PreparedStatement makeStatement(Connection connection) throws SQLException {
        return connection.prepareStatement("delete from USERS");
    }
}
