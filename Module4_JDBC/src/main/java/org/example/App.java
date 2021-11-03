/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 02.11.2021
 */

package org.example;

import org.example.dao.DbHelper;
import org.example.model.User;

import java.sql.*;
import java.util.*;

public class App {
    public static void main( String[] args ) throws SQLException {
        
        DbHelper.connectToDb();
        
//        User user = new User();
//        user.setId(5L);
//        user.setName("Sakai");
//        user.setDescription("Common user");
//        updateUser(user);

        getAllUsers();
        DbHelper.closeConnection();
    }

    private static void deleteUser(User user) throws SQLException {
        try(Connection connection = DbHelper.getConnection("localhost", 5432,
                "postgres", "postgres", "A1S5nkO/J2*33Wu");
            Statement statement = connection.createStatement()) {
            String sql = "delete from users where id = %s";
            statement.execute(
                    String.format(sql, user.getId()));
            System.out.printf("Record was deleted ");
        }
    }

    private static void createUser(User user) throws SQLException {
        try(Connection connection = DbHelper.getConnection("localhost", 5432,
                "postgres", "postgres", "A1S5nkO/J2*33Wu");
            Statement statement = connection.createStatement()) {
            String sql = "insert into users(name, description) values ('%s', '%s')";
           statement.execute(
                   String.format(sql, user.getName(), user.getDescription()));
            System.out.printf("Record was created ");
        }
    }

    private static void updateUser(User user) throws SQLException {
        String sql = "update users set name = ? where id = ?";

        DbHelper.executeWithPreparedStatement(sql, ps -> {
                ps.setString(1, user.getName());
                ps.setLong(2, user.getId());
        });
   }

    private static void getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                "select * from users", ps -> {});
        while (resultSet.next()) {
            users.add(convertUser(resultSet));
        }
        System.out.println(users);
    }

    public static User convertUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setDescription(resultSet.getString("description"));
        return user;
    }
}
