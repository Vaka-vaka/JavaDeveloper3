/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 02.11.2021
 */

package org.example.dao;

import org.example.model.User;

import java.util.*;

public class UserDao implements Dao<User> {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> create(User entity) {
        return Optional.empty();
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }


}
