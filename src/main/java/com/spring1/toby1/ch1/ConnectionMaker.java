package com.spring1.toby1.ch1;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
