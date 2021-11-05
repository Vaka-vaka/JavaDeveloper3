/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package org.example;

import org.example.dao.DbHelper;
import org.example.model.User;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        User user = getUser(4L);
        if (user != null) {
            System.out.println(user);
            user.setName("Ork");
            user.setDescription("grin");
            //  createUser(user);
      //        deleteUser(user);
            updateUser(user);
            user = getUser(4L);
            System.out.println(user);
        }
         //   getAllUsers();
    }

    private static void deleteUser(User user) {
        String sql = "delete from users where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, user.getId());
        });
        System.out.println("Deleted " + count + " records");
    }

    private static void createUser(User user) {
        String sql = "insert into users(name, description) values (?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setString(2, user.getDescription());
        });
        System.out.println("Created " + count + " records");
    }


    private static void updateUser(User user) {
        String sql = "update users set name = ?, description = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setString(2, user.getDescription());
            ps.setLong(3, user.getId());
        });
        System.out.println("Updated " + count + " records");
    }

    private static void getAllUsers() throws SQLException { //непаше ??
        List<User> users = new ArrayList<>();
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                "select * from users", ps -> {
                });
        while (resultSet.next()) {
            users.add(convertUser(resultSet));
        }
        System.out.println(users);
    }

    private static User getUser(Long id) throws SQLException {
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                "select * from users where id = ?", ps -> {
                    ps.setLong(1, id);
                });
        if (resultSet.next()) {
            System.out.println("Record was selected");
            return convertUser(resultSet);
        } else {
            return null;
        }
    }

    public static User convertUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setDescription(resultSet.getString("description"));
        return user;
    }
}
