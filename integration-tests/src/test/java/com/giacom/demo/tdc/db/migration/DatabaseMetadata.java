package com.giacom.demo.tdc.db.migration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.flywaydb.core.Flyway;

public class DatabaseMetadata {

    static List<String> getColNames(Flyway flyway) throws SQLException {
        List<String> columnNames = new ArrayList<>();
        try (Connection con = flyway.getDataSource().getConnection()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery("SELECT * from sample_user");
                int columns = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columns; i++) {
                    columnNames.add(rs.getMetaData().getColumnName(i));
                }
            }
        }
        return columnNames;
    }

}
