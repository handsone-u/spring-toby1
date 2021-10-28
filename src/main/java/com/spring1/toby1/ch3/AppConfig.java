package com.spring1.toby1.ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public UserDaoV4 userDaoV4() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return new UserDaoV4(jdbcTemplate, dataSource());
    }

    @Bean
    public UserDaoV3 userDaoV3() {
        UserDaoV3 dao = new UserDaoV3();
        dao.setJdbcContext(jdbcContext());
        dao.setDataSource(dataSource());
        return dao;
    }

    @Bean
    public JdbcContext jdbcContext() {
        return new JdbcContext();
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
}
