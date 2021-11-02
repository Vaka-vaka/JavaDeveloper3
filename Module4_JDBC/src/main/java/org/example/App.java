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
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws SQLException {

 //       getAllUsers();
        User user = new User();
        user.setId(6L);
        user.setName("normal user");
        user.setDescription("Common user");
        deleteUser(user);
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
        try(Connection connection = DbHelper.getConnection("localhost", 5432,
                "postgres", "postgres", "A1S5nkO/J2*33Wu");
            Statement statement = connection.createStatement()) {
            String sql = "update users set name = '%s' where id = %s";
            int i = statement.executeUpdate(String.format(sql, user.getName(), user.getId()));
            System.out.printf("Updated %s records",  i);
        }
    }

    private static void getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try(Connection connection = DbHelper.getConnection("localhost", 5432,
                "postgres", "postgres", "A1S5nkO/J2*33Wu");
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                users.add(convertUser(resultSet));
            }
            resultSet.close();
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
