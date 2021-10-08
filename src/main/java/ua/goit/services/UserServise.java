package ua.goit.services;

import ua.goit.*;
import java.util.*;
import java.util.stream.Collectors;

public class UserServise {

    private Map<Integer, User> userMap = new HashMap<>();

    //метод сохраняем юзера
    public void putUser(User user) {
        userMap.put(user.getId(), user);
    }

    //метод возврат юзера
    public User getUser(Integer id) {
        return userMap.get(id);
    }
    
    //метод возвращае юзеров старше зазначеного року
    public List<User> getUsersOlderThan(Integer compare) {
        return userMap.values().stream()
                   .filter(user -> user.getAge() > compare)
                   .collect(Collectors.toList());
    }

    //метод возврата юзеров по полу
    public List<User> getUsersBySex(Sex sex) {
        return userMap.values().stream()
                .filter(user -> user.getSex().equals(sex))
                .collect(Collectors.toList());
    }

}
