/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 08.11.2021
 */

package org.example.commands;

import org.example.dao.UserDao;
import org.example.model.User;

import java.util.Optional;

public class CommandUsers implements Command {

    private final UserDao userDao = new UserDao();

    @Override
    public void handle(String params) {
        int firstSpace = params.indexOf(" ");
        if (firstSpace > -1) {
            String subCommand = params.substring(0, firstSpace);
            String subParams = params.substring(firstSpace + 1);
            switch (subCommand) {
                case "create":
                    create(subParams);
                case "get":
                    get(subParams);
                case "getAll":
                    getAll();
                case "delete":
                    delete(subParams);
                case "update":
                    update(subParams);
            }
        }
    }

    private void getAll() {
        System.out.println(userDao.getAll());
    }

    private void update(String params) { // user update ID NAME DESCRIPTION
        String[] paramsArray = params.split(" ");
        Optional<User> optionalUser = userDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalUser.isPresent()) {
          User user = optionalUser.get();
            user.setName(paramsArray[1]);
            user.setDescription(paramsArray[2]);
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
