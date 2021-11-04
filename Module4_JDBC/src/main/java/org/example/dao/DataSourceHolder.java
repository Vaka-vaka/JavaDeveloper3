/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 04.11.2021
 */

package org.example.dao;

import org.postgresql.ds.*;
import javax.sql.*;
import java.io.FileInputStream;
import java.util.*;

public class DataSourceHolder {

    private static DataSourceHolder value;

    private final DataSource dataSource;

    private DataSourceHolder() {
        PGSimpleDataSource dataSourse = new PGSimpleDataSource();
        dataSourse.setServerNames(new String[]{"werty"});
        dataSourse.setPortNumbers(new int[]{333});
        dataSourse.setDatabaseName("postgres");
        dataSourse.setUser("postgres");
        dataSourse.setPassword("postgres");
        this.dataSource = dataSourse;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/application.properties"));
    }

    public static DataSource getDataSource() {
        if (value == null) {
            value = new DataSourceHolder();
        }
        return value.dataSource;
    }
}
