package com.spring1.toby1.ch1;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    @Test
    public void dao1TestV1() throws SQLException, ClassNotFoundException {
        UserDao1 dao = new UserDao1();

        User1 user = new User1("id1", "name1", "pass1");

        dao.addV1(user);
        System.out.println(user.getId() + " 등록!");

        User1 getUser = dao.getV1(user.getId());
        System.out.println(getUser.getId() + " 조회!");

        assertThat(user.getId()).isEqualTo(getUser.getId());
        System.out.println("등록&조회 성공");
    }

    @Test
    void dao1TestV2() throws SQLException, ClassNotFoundException {
        UserDao1 dao = new UserDao1();

        User1 user = new User1("id2", "name1", "pass1");

        dao.addV2(user);
        System.out.println(user.getId() + " 등록!");

        User1 getUser = dao.getV2(user.getId());
        System.out.println(getUser.getId() + " 조회!");

        assertThat(user.getId()).isEqualTo(getUser.getId());
        System.out.println("등록&조회 성공");
    }

    @Test
    void nDao2Test() throws SQLException, ClassNotFoundException {
        UserDao2 dao = new NUserDao2();

        User1 user = new User1("id1", "name1", "pass1");

        dao.add(user);
        System.out.println(user.getId() + " 등록!");

        User1 getUser = dao.get(user.getId());
        System.out.println(getUser.getId() + " 조회!");

        assertThat(user.getId()).isEqualTo(getUser.getId());
        System.out.println("등록&조회 성공");
    }
}