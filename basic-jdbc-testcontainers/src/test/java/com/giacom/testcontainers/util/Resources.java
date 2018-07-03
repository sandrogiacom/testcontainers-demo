package com.giacom.testcontainers.util;

import javax.sql.DataSource;

import org.testcontainers.containers.JdbcDatabaseContainer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public abstract class Resources {

    public static DataSource getDataSource(JdbcDatabaseContainer container) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setAutoCommit(true);
        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        return ds;
    }

}
