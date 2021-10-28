package com.spring1.toby1.ch3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatement implements StatementStrategy {
    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement("delete from USERS");
    }
}
