package com.spring1.toby1.ch1;

import com.spring1.toby1.ch1.factory.DaoFactory;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDao4Test {

    @Test
    void daoFactoryTest() throws SQLException, ClassNotFoundException {
        UserDao4 dao = new DaoFactory().userDao();

        User1 user = new User1("id2", "name1", "pass1");

        dao.add(user);
        System.out.println(user.getId() + " 등록!");

        User1 getUser = dao.get(user.getId());
        System.out.println(getUser.getId() + " 조회!");

        assertThat(user.getId()).isEqualTo(getUser.getId());
        System.out.println("등록&조회 성공");
    }
}