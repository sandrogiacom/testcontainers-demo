package com.giacom.demo.tdc.db.migration;


import static com.giacom.demo.tdc.db.migration.DatabaseMetadata.getColumns;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.giacom.demo.tdc.config.exception.InvalidDatabaseVendorException;
import com.giacom.demo.tdc.config.factory.DatabaseFactory;
import com.giacom.demo.tdc.config.jdbc.AbstractDatabaseTest;

@RunWith(Parameterized.class)
public class DbMigrationIT {

    AbstractDatabaseTest dbTest;

    @Parameter
    public static String dbVendor;

    @Parameters(name = "{0}")
    public static List<String> params() {
        return Arrays.asList("mysql", "oracle", "postgresql");
    }

    @Before
    public void initDatabase() throws InvalidDatabaseVendorException {
        dbTest = DatabaseFactory.getDatabase(dbVendor);
    }

    @Test
    public void createSampleUserTable() throws SQLException {
        Flyway flyway = new Flyway();
        flyway.setLocations("db/migration/" + dbVendor);
        flyway.setDataSource(dbTest.getJdbcUrl(), dbTest.getUsername(), dbTest.getPassword());
        flyway.setBaselineOnMigrate(true);
        flyway.setBaselineVersionAsString("0");
        flyway.migrate();

        List<String> columnNames = getColumns(flyway, dbVendor, "SAMPLE_USER");
        assertThat(columnNames)
                .hasSize(4)
                .containsExactlyInAnyOrder("ID", "NAME", "LAST_NAME", "AGE");
    }

}
