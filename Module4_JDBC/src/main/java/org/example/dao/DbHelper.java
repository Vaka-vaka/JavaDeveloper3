/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 02.11.2021
 */

package org.example.dao;

import java.sql.*;

public class DbHelper {
    private static Connection connection;

    private static String url = "jdbc:postgresql://%s:%s/%s?user=%s&password=%s";


    public static void connectToDb() throws SQLException {
        connection = getConnection("localhost", 5432,
                "postgres", "postgres", "A1S5nkO/J2*33Wu");
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

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
