/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 02.11.2021
 */

package org.example;

import org.example.dao.DbHelper;

import java.sql.*;

public class App 
{
    public static void main( String[] args ) throws SQLException {

        try(Connection connection = DbHelper.getConnection("localhost", 5432,
                "postgres", "postgres", "A1S5nkO/J2*33Wu");
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            resultSet.next();
            System.out.println(resultSet.getString("name"));
            resultSet.close();
        }
    }
}
