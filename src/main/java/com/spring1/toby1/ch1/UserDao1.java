package com.spring1.toby1.ch1;

import org.apache.catalina.User;

import java.sql.*;

public class UserDao1 {
    public void addV1(User1 user) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/./toby", "sa", "sa");

        PreparedStatement ps = c.prepareStatement("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        int count = ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User1 getV1(String id) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/./toby", "sa", "sa");

        PreparedStatement ps = c.prepareStatement("select * from USERS where ID = ?");
        ps.setString(1, id);

        ResultSet resultSet = ps.executeQuery();
        resultSet.next();

        User1 user1 = new User1();
        user1.setId(resultSet.getString("ID"));
        user1.setName(resultSet.getString("NAME"));
        user1.setPassword(resultSet.getString("PASSWORD"));

        resultSet.close();
        ps.close();
        c.close();

        return user1;
    }

    public void addV2(User1 user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        int count = ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User1 getV2(String id) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("select * from USERS where ID = ?");
        ps.setString(1, id);

        ResultSet resultSet = ps.executeQuery();
        resultSet.next();

        User1 user1 = new User1();
        user1.setId(resultSet.getString("ID"));
        user1.setName(resultSet.getString("NAME"));
        user1.setPassword(resultSet.getString("PASSWORD"));

        resultSet.close();
        ps.close();
        c.close();

        return user1;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:h2:tcp://localhost/./toby", "sa", "sa");
        return connection;
    }
}
