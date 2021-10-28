package com.spring1.toby1.ch1.factory;

import com.spring1.toby1.ch1.User1;
import com.spring1.toby1.ch1.UserDao4;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {

//    @Test
    public void beanFactoryTest() throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanFactory.class);

        UserDao4 dao = context.getBean("userDao", UserDao4.class);

        User1 user = new User1("bean", "name1", "pass1");

        dao.add(user);
        System.out.println(user.getId() + " 등록!");

        User1 getUser = dao.get(user.getId());
        System.out.println(getUser.getId() + " 조회!");

        assertThat(user.getId()).isEqualTo(getUser.getId());
        System.out.println("등록&조회 성공");
    }

    @Test
    public void nonSingleton() {
        DaoFactory daoFactory = new DaoFactory();

        UserDao4 bean1 = daoFactory.userDao4();
        UserDao4 bean2 = daoFactory.userDao4();

        System.out.println("bean1 = " + bean1);;
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isNotEqualTo(bean2);
        assertThat(bean1).isNotSameAs(bean2);
    }

    @Test
    public void singleton() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanFactory.class);

        UserDao4 bean1 = context.getBean(UserDao4.class);
        UserDao4 bean2 = context.getBean(UserDao4.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isSameAs(bean2);
        assertThat(bean1).isEqualTo(bean2);
    }
}