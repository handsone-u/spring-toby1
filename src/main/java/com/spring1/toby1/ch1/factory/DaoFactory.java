package com.spring1.toby1.ch1.factory;

import com.spring1.toby1.ch1.ConnectionMaker;
import com.spring1.toby1.ch1.NConnectionMaker;
import com.spring1.toby1.ch1.UserDao4;

public class DaoFactory {
    public UserDao4 userDao() {
        NConnectionMaker connectionMaker = new NConnectionMaker();
        UserDao4 dao = new UserDao4(connectionMaker);
        return dao;
    }

    public UserDao4 userDao4() {
        return new UserDao4(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}
