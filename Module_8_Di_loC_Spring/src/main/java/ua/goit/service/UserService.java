package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.model.Developers;
import ua.goit.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepository repository;

    public void printAllUsers() {
        repository.findAll().forEach(System.out::println);
    }

    public void printGetUsers() {
        Optional<Developers> byId = repository.findById(4L);
        if(byId.isPresent()) {
            Developers developers = byId.get();
            System.out.println(developers);
        }

    }

}
