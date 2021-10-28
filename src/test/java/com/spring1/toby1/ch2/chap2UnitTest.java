package com.spring1.toby1.ch2;

import com.spring1.toby1.ch1.User1;
import com.spring1.toby1.ch1.UserDao4;
import com.spring1.toby1.ch1.factory.DaoFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationContext.class)
class chap2UnitTest {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserDaoforTest dao;
    static List<User1> users = new ArrayList<>();

    @AfterEach
    public void delete() throws SQLException {
        dao.deleteAll();
    }

    @BeforeAll
    public static void init() {
        users.add(new User1("id1", "name1", "p1"));
        users.add(new User1("id2", "name2", "p2"));
    }

    @Test
    @DirtiesContext
    void addTest() throws SQLException {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource
                ("jdbc:h2:tcp://localhost/./toby", "sa", "sa", true);
        dao.setDataSource(dataSource);

        User1 user = users.get(0);

        dao.add(user);
        System.out.println(user.getId() + " 등록!");

        User1 getUser = dao.get(user.getId());
        System.out.println(getUser.getId() + " 조회!");

        assertThat(user.getId()).isEqualTo(getUser.getId());
        System.out.println("등록&조회 성공");
    }
}