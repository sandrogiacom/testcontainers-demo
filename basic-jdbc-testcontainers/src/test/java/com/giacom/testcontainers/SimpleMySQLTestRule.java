package com.giacom.testcontainers;

import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class SimpleMySQLTestRule {

    @Rule
    public MySQLContainer mysql = new MySQLContainer();

    @Test
    public void isolateTest_1() {
        System.out.println("URL test 1: " + mysql.getJdbcUrl());
    }

    @Test
    public void isolateTest_2() {
        System.out.println("URL test 2: " + mysql.getJdbcUrl());
    }

}
