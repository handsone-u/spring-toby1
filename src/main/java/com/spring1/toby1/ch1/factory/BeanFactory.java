package com.spring1.toby1.ch1.factory;

import com.spring1.toby1.ch1.ConnectionMaker;
import com.spring1.toby1.ch1.NConnectionMaker;
import com.spring1.toby1.ch1.UserDao4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class BeanFactory {

    @Bean
    public UserDao4 userDao() {
        return new UserDao4(connectionMaker());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUrl("jdbc:h2:tcp://localhost/./toby");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        return dataSource;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}
