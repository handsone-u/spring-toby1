package com.spring1.toby1.ch3;

import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class UserDaoV1 {
    private DataSource dataSource;

    public void add(User user) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("insert into USERS(iD, NAME, PASSWORD) values (?,?,?)");
            ps.setString(1,user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps!=null){
                try {ps.close();}
                catch (SQLException e){}
            }
            if (c != null) {
                try {c.close();}
                catch (SQLException e) {}
            }
        }
    }

    public void deleteAll() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("delete from USERS");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps!=null){
                try {ps.close();}
                catch (SQLException e){}
            }
            if (c != null) {
                try {c.close();}
                catch (SQLException e) {}
            }
        }
    }

    public void deleteAllV3_1() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            StatementStrategy strategy = new DeleteAllStatement();
            ps = strategy.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps!=null){
                try {ps.close();}
                catch (SQLException e){}
            }
            if (c != null) {
                try {c.close();}
                catch (SQLException e) {}
            }
        }
    }

    public void deleteAllV3_2() throws SQLException {
        jdbcContextWithStatementStrategy(new DeleteAllStatement());
    }

    public int getCount() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("select count(*) from USERS");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                try {rs.close();}
                catch (SQLException e){}
            }
            if(ps!=null){
                try {ps.close();}
                catch (SQLException e){}
            }
            if (c != null) {
                try {c.close();}
                catch (SQLException e) {}
            }
        }
    }

    public User get(String id) throws SQLException {
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select * from USERS where ID = ?");
        ps.setString(1, id);

        ResultSet resultSet = ps.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("ID"));
        user.setName(resultSet.getString("NAME"));
        user.setPassword(resultSet.getString("PASSWORD"));

        resultSet.close();
        ps.close();
        c.close();

        return user;
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy strategy) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            ps = strategy.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps!=null){
                try {ps.close();}
                catch (SQLException e){}
            }
            if (c != null) {
                try {c.close();}
                catch (SQLException e) {}
            }
        }
    }

    private PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement ps;
        ps = connection.prepareStatement("delete from USERS");
        return ps;
    }
}
