package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ua.goit.model.User;
import ua.goit.model.UserDevelopers;
import ua.goit.reposetories.UserDevelopersRepository;
import ua.goit.reposetories.UserRepository;

import java.util.Optional;

@Service
public class TestClass implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserDevelopersRepository developersRepository;


    @Override
    public void run(String... args) throws Exception {
        Optional<UserDevelopers> developersRepositoryById = developersRepository.findById(3L);
        developersRepositoryById.ifPresent(user -> System.out.println(user.getLastName()));

//        Optional<User> optionalUser = repository.findById(1L);
//        optionalUser.ifPresent(user -> System.out.println(user.getLastName()));

    }
}
