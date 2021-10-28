package com.spring1.toby1.ch1.sql;

import com.spring1.toby1.ch1.ConnectionMaker;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class CountingConnectionMaker implements ConnectionMaker {
    private int counter = 0;
    private ConnectionMaker connectionMaker;

    public CountingConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return null;
    }
}
