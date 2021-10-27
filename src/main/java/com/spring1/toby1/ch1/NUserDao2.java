package com.spring1.toby1.ch1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao2 extends UserDao2{
    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:h2:tcp://localhost/./toby", "sa", "sa");
        return connection;
    }
}
