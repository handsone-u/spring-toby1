package com.spring1.toby1.ch3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractUserDao {
    protected abstract PreparedStatement makeStatement(Connection connection) throws SQLException;
}
