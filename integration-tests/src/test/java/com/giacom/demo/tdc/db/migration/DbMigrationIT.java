package com.giacom.demo.tdc.db.migration;


import static com.giacom.demo.tdc.db.migration.DatabaseMetadata.getColNames;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.flywaydb.core.Flyway;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.MySQLContainer;

public class DbMigrationIT {

    @Rule
    public MySQLContainer mySql = new MySQLContainer("mysql:5.6");

    @Test
    public void createSampleUserTable() throws InterruptedException, SQLException {
        Flyway flyway = new Flyway();
        flyway.setDataSource(mySql.getJdbcUrl(), mySql.getUsername(), mySql.getPassword());

        flyway.migrate();

        List<String> columnNames = getColNames(flyway);
        assertThat(columnNames)
                .hasSize(4)
                .containsExactlyInAnyOrder("id", "name", "last_name", "age");
    }

}
