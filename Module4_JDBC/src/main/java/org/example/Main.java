/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package org.example;

import org.example.dao.Dao;
import org.example.dao.UserDao;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dao<?> userDao = new UserDao();

        System.out.println("Start application");
        List<?> all = userDao.getAll();

        System.out.println(all);


        userDao.get(10L)
                .ifPresent(System.out :: println);
        System.out.println("And application");

//        User user = getUser(4L);
//        if (user != null) {
//            System.out.println(user);
//            user.setName("Ork");
//            user.setDescription("grin");
//            //  createUser(user);
//      //        deleteUser(user);
//            updateUser(user);
//            user = getUser(4L);
//            System.out.println(user);
//        }
         //   getAllUsers();
    }

}
