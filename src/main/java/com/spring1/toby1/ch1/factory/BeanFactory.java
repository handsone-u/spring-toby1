package com.spring1.toby1.ch1.factory;

import com.spring1.toby1.ch1.ConnectionMaker;
import com.spring1.toby1.ch1.NConnectionMaker;
import com.spring1.toby1.ch1.UserDao4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public UserDao4 userDao() {
        return new UserDao4(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}
