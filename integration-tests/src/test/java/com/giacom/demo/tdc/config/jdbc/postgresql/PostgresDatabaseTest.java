package com.giacom.demo.tdc.config.jdbc.postgresql;

import org.testcontainers.containers.PostgreSQLContainer;

import com.giacom.demo.tdc.config.jdbc.AbstractDatabaseTest;

public class PostgresDatabaseTest extends AbstractDatabaseTest {

    PostgreSQLContainer postgresql;

    public PostgresDatabaseTest() {
        postgresql = new PostgreSQLContainer();
        postgresql.start();
        setJdbcDatabaseContainer(postgresql);
    }

    @Override
    public String getDriverClassName() {
        return postgresql.getDriverClassName();
    }

}
