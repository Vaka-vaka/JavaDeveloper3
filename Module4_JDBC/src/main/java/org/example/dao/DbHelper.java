/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 03.11.2021
 */

package org.example.dao;

import java.sql.*;
import java.util.function.*;

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

    public static void executeWithPreparedStatement(String sql, ParameterSetter psCall) {
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            psCall.set(ps);
            int i = ps.executeUpdate();
            System.out.printf("Updated %s records",  i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet getWithPreparedStatement(String sql, ParameterSetter psCall) {
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            psCall.set(ps);
            return ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @FunctionalInterface
   public interface ParameterSetter {
        void set (PreparedStatement ps) throws SQLException;
    }

}
