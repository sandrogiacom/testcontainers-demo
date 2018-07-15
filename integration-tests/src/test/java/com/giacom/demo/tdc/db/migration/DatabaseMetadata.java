package com.giacom.demo.tdc.db.migration;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.flywaydb.core.Flyway;

public class DatabaseMetadata {

    static public List<String> getColumns(Flyway flyway, String vendor, String table) throws SQLException {
        List<String> columns = new ArrayList<>(0);
        try (Connection connection = flyway.getDataSource().getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet resultSet = metaData.getColumns(null, null,
                    (vendor.equals("postgresql") || vendor.equals("mysql")) ? table.toLowerCase() : table, null)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("COLUMN_NAME");
                    columns.add(name.toUpperCase());
                }
            }
            return columns;
        }
    }

}
