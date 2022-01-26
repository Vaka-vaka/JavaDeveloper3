package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void printAllUsers() {
        repository.findAll().forEach(System.out::println);
    }

}
