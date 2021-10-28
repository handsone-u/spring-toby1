package com.spring1.toby1.ch2;

import com.spring1.toby1.ch1.User1;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@Setter
public class UserDaoforTest {
    private DataSource dataSource;

    public void add(User1 user) throws SQLException {
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        int count = ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User1 get(String id) throws SQLException {
        Connection c = dataSource.getConnection();

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

    public void deleteAll() throws SQLException {
        Connection connection = dataSource.getConnection();

        PreparedStatement ps = connection.prepareStatement("delete from USERS");
        ps.execute();
    }
}
