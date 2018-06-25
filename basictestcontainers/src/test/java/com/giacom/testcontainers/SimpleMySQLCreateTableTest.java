package com.giacom.testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

import com.giacom.testcontainers.util.DbTestUtil;
import com.giacom.testcontainers.util.Resources;

public class SimpleMySQLCreateTableTest {

    @Rule
    public MySQLContainer mysql = new MySQLContainer();

    static final String createTable = "CREATE TABLE `APP_USER` ("
            + "  `USER_ID` varchar(36) NOT NULL,"
            + "  `USER_CODE` varchar(32) NOT NULL,"
            + "  `USER_NAME` varchar(255) NOT NULL,"
            + "  `USER_PASSWD` varchar(50) NOT NULL,"
            + "  PRIMARY KEY (`USER_ID`)"
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";


    @Test
    public void isTableCreated() throws SQLException {
        DataSource ds = Resources.getDataSource(mysql);
        try (Connection con = ds.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.execute(createTable);
            }
        }

        //Testa a criaçao da tabela e campos
        String tableName = "APP_USER";
        List<String> fields = Arrays.asList("USER_ID",
                "USER_CODE", "USER_NAME",
                "USER_PASSWD");

        DbTestUtil dbTestUtil = new DbTestUtil(ds);
        assertThat(dbTestUtil.getColumns(tableName)).hasSize(4).containsAll(fields);

    }

}
