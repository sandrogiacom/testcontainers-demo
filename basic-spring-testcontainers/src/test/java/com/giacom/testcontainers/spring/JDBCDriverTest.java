package com.giacom.testcontainers.spring;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDriverTest {

    public static void sampleInitFunction(Connection connection) throws SQLException {
        System.out.println("\n@@@@@@ init function @@@@@");
        System.out.println(connection.getMetaData().getURL());
        System.out.println();
    }

}
