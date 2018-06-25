package com.giacom.demo.tdc.v1.controller;

import javax.sql.DataSource;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.MySQLContainer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@TestConfiguration
public class TestConfigurations {

    public MySQLContainer mySql = new MySQLContainer("mysql:5.6");

    public TestConfigurations(){
        mySql.start();
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setDataSource(driverManagerDataSource());
        hikariConfig.setConnectionTimeout(2147483647L);
        hikariConfig.setAutoCommit(true);
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        setDBproperties();
        return ds;
    }

    private void setDBproperties() {
        System.setProperty("database.driver", mySql.getDriverClassName());
        System.setProperty("database.user", mySql.getUsername());
        System.setProperty("database.password", mySql.getPassword());
        System.setProperty("database.url", mySql.getJdbcUrl());
    }

    private DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
                mySql.getJdbcUrl(),
                mySql.getUsername(),
                mySql.getPassword());
        driverManagerDataSource.setDriverClassName(mySql.getDriverClassName());
        return driverManagerDataSource;
    }

}
