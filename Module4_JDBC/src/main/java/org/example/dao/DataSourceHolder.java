/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 04.11.2021
 */

package org.example.dao;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

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

    public static DataSource getDataSource() {
        if (value == null) {
            value = new DataSourceHolder();
        }
        return value.dataSource;
    }
}
