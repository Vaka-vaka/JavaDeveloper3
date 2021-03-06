/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 08.11.2021
 */

package org.example.console.commands;

import org.example.console.Command;
import org.example.dao.UserDao;
import org.example.model.User;

import java.util.List;
import java.util.Optional;

public class UsersCommand implements Command {

    private final UserDao userDao = new UserDao();

    @Override
    public void handle(String params) {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" ", params.replace(paramsArray[0] + " ", ""));
            switch (paramsArray[0]) {
                case "create":
                    create(subParams);break;
                case "get":
                    get(subParams);break;
                case "getAll":
                    getAll();break;
                case "delete":
                    delete(subParams);break;
                case "update":
                    update(subParams);break;
            }
        }


    private void getAll() {
        List<User> all = userDao.getAll();
        System.out.println("Returned " + all.size() + " users");
        for (User user : all) {
            System.out.println(user);
        }
    }

    private void update(String params) { // user update ID NAME DESCRIPTION
        String[] paramsArray = params.split(" ");
        Optional<User> optionalUser = userDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalUser.isPresent()) {
          User user = optionalUser.get();
            user.setName(paramsArray[1]);
            user.setDescription(paramsArray[2]);
            userDao.update(user);
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String params) { //users create Name DESCRIPTION
        String[] paramsArray = params.split(" ");
        User user = new User();
        user.setName(paramsArray[0]);
        user.setDescription(paramsArray[1]);
        userDao.create(user);
    }

    private void get(String params) { //users get 1
        String[] paramsArray = params.split(" ");
        Optional<User> user = userDao
                .get(Long.parseLong(paramsArray[0]));
        if (user.isPresent()) {
            System.out.println(user.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) {
        String[] paramsArray = params.split(" ");
        Optional<User> user = userDao
                .get(Long.parseLong(paramsArray[0]));
        if (user.isPresent()) {
            userDao.delete(user.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }
}
