package com.giacom.testcontainers.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "setup_database.sql")
public class SpringDemoApplicationTests {

    @Test
    public void peopleFindTest() {

        //usar o restassured para testar as urls
        System.out.println("@@@@@@ no teste @@@@@");


    }

}
