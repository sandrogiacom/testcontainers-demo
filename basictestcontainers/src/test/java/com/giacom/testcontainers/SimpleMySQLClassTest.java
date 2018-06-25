package com.giacom.testcontainers;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class SimpleMySQLClassTest {

    @ClassRule
    public static MySQLContainer mysql = new MySQLContainer();

    @Test
    public void classRuleTest_1() {
        System.out.println(mysql.getJdbcUrl());
    }

    @Test
    public void classRuleTest_2() {
        System.out.println(mysql.getJdbcUrl());
    }

}
