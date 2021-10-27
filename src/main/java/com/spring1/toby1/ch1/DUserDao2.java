package com.spring1.toby1.ch1;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao2 extends UserDao2{
    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        // D's db connection
        return null;
    }
}
