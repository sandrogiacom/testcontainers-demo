package com.giacom.demo.tdc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.giacom.demo.tdc.config.exception.InvalidDatabaseVendorException;
import com.giacom.demo.tdc.config.factory.DatabaseFactory;
import com.giacom.demo.tdc.config.jdbc.AbstractDatabaseTest;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@TestConfiguration
public class TestConfigurations {

    AbstractDatabaseTest dbTest;
    private String dbVendor;

    @Autowired
    public TestConfigurations() throws InvalidDatabaseVendorException {
        this.dbVendor = System.getProperty("dbVendor", "mysql");
        System.out.println("##########################");
        System.out.println("dbVendor = " + dbVendor);
        System.out.println("##########################");
        dbTest = DatabaseFactory.getDatabase(dbVendor);
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setDataSource(driverManagerDataSource());
        hikariConfig.setConnectionTimeout(2147483647L);
        hikariConfig.setAutoCommit(true);
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        return ds;
    }

    private DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
                dbTest.getJdbcUrl(),
                dbTest.getUsername(),
                dbTest.getPassword());
        driverManagerDataSource.setDriverClassName(dbTest.getDriverClassName());
        return driverManagerDataSource;
    }

}
