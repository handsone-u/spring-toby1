package com.spring1.toby1.ch1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor @NoArgsConstructor
public class UserDao3 {
    private SimpleConnectionMaker connectionMaker;

    public void add(User1 user) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        int count = ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User1 get(String id) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();

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
}
