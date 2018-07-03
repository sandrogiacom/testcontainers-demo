package com.giacom.testcontainers.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DbTestUtil {

    private DataSource dataSource;

    private DbTestUtil() {
    }

    public DbTestUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getColumns(String table) throws SQLException {
        List<String> columns = new ArrayList<>(0);
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet resultSet = metaData.getColumns(null, null, table, null)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("COLUMN_NAME");
                    columns.add(name);
                }
            }
            return columns;
        }
    }

}
