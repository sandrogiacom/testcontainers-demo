package com.giacom.testcontainers.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "setup_database.sql")
public class SpringDemoApplicationTests {

    @Autowired
    DataSource ds;

    @Test
    public void peopleFindTest() throws SQLException {
        System.out.println("@@@@@@ inside test @@@@@: " + ds.getConnection().getMetaData().getURL());
    }

}
