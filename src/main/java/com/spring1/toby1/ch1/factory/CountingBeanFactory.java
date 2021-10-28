package com.spring1.toby1.ch1.factory;

import com.spring1.toby1.ch1.ConnectionMaker;
import com.spring1.toby1.ch1.NConnectionMaker;
import com.spring1.toby1.ch1.UserDao4;
import com.spring1.toby1.ch1.sql.CountingConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingBeanFactory {
    @Bean
    public UserDao4 userDao() {
        return new UserDao4(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new NConnectionMaker();
    }
}
