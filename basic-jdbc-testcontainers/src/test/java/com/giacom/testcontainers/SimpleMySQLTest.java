package com.giacom.testcontainers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class SimpleMySQLTest {

    public MySQLContainer mysql = new MySQLContainer();

    @Before
    public void init() {
        mysql.start();
    }

    @Test
    public void mysqlTest() {
        System.out.println("URL test: " + mysql.getJdbcUrl());
    }

    @After
    public void stop() {
        mysql.stop();
    }

}
