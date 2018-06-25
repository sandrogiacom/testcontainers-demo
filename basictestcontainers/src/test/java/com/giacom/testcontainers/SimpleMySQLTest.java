package com.giacom.testcontainers;

import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class SimpleMySQLTest {

    @Rule
    public MySQLContainer mysql = new MySQLContainer();

    @Test
    public void isolateTest_1() {
        System.out.println(mysql.getJdbcUrl());
    }

    @Test
    public void isolateTest_2() {
        System.out.println(mysql.getJdbcUrl());
    }

}
