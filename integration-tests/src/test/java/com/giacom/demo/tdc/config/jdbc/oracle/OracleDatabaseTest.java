package com.giacom.demo.tdc.config.jdbc.oracle;

import org.testcontainers.containers.OracleContainer;

import com.giacom.demo.tdc.config.jdbc.AbstractDatabaseTest;

public class OracleDatabaseTest extends AbstractDatabaseTest {

    //    private static final String IMAGE_NAME = "wnameless/oracle-xe-11g:latest";
    private static final String IMAGE_NAME = "pengbai/docker-oracle-12c-r1";
    OracleContainer oracle;

    public OracleDatabaseTest() {
        oracle = new OracleContainer(IMAGE_NAME);
        oracle.start();
        setJdbcDatabaseContainer(oracle);
    }

    @Override
    public String getDriverClassName() {
        return oracle.getDriverClassName();
    }

}
