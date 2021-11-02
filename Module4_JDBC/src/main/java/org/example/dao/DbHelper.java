/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 02.11.2021
 */

package org.example.dao;

import java.sql.*;

public class DbHelper {

    private static String url = "jdbc:postgresql://%s:%s/%s?user=%s&password=%s";

    public static Connection getConnection(
            String host,
            int port,
            String dbName,
            String user,
            String password) throws SQLException {
        return DriverManager.getConnection(
                String.format(url, host, port, dbName, user, password)
        );
    }

}
