package com.giacom.demo.tdc.config.factory;

import com.giacom.demo.tdc.config.DataBaseVendor;
import com.giacom.demo.tdc.config.exception.InvalidDatabaseVendorException;
import com.giacom.demo.tdc.config.jdbc.AbstractDatabaseTest;
import com.giacom.demo.tdc.config.jdbc.mysql.MySqlDatabaseTest;
import com.giacom.demo.tdc.config.jdbc.oracle.OracleDatabaseTest;
import com.giacom.demo.tdc.config.jdbc.postgresql.PostgresDatabaseTest;

public class DatabaseFactory {

    public static AbstractDatabaseTest getDatabase(String dbVendor) throws InvalidDatabaseVendorException {
        DataBaseVendor vendor = DataBaseVendor.of(dbVendor);

        switch (vendor) {
            case MYSQL:
                return new MySqlDatabaseTest();
            case ORACLE:
                return new OracleDatabaseTest();
            case POSTGRESQL:
                return new PostgresDatabaseTest();
            default:
                throw new InvalidDatabaseVendorException(dbVendor + " is not supported!");
        }
    }
}