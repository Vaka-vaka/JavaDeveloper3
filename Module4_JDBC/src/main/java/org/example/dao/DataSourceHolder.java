/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 04.11.2021
 */

package org.example.dao;

import org.example.config.AppProperties;
import org.postgresql.ds.*;
import javax.sql.*;
import java.util.*;

public class DataSourceHolder {

    private static DataSourceHolder value;

    private final DataSource dataSource;

    private DataSourceHolder() {
        Properties properties = AppProperties.getProperties();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerNames(new String[]{properties.getProperty("db.host")});
        dataSource.setPortNumbers(new int[]{Integer.parseInt(properties.getProperty("db.port"))});
        dataSource.setDatabaseName(properties.getProperty("db.databaseName"));
        dataSource.setUser(properties.getProperty("db.username"));
        dataSource.setPassword(properties.getProperty("db.password"));
        this.dataSource = dataSource;
    }

    public static DataSource getDataSource() {
        if (value == null) {
            value = new DataSourceHolder();
        }
        return value.dataSource;
    }
}
