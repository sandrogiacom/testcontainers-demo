package com.giacom.demo.tdc.config.jdbc;

import org.testcontainers.containers.JdbcDatabaseContainer;

public abstract class AbstractDatabaseTest {

    JdbcDatabaseContainer jdbcDatabaseContainer;

    protected void setJdbcDatabaseContainer(JdbcDatabaseContainer jdbcDatabaseContainer) {
        this.jdbcDatabaseContainer = jdbcDatabaseContainer;
    }

    public String getJdbcUrl() {
        return jdbcDatabaseContainer.getJdbcUrl();
    }

    public String getUsername() {
        return jdbcDatabaseContainer.getUsername();
    }

    public String getPassword() {
        return jdbcDatabaseContainer.getPassword();
    }

    public abstract String getDriverClassName();


}



