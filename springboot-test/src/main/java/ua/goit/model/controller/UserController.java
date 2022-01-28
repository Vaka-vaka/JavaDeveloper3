package ua.goit.model.controller;

import org.springframework.web.bind.annotation.*;
import ua.goit.model.User;
import ua.goit.model.UserDevelopers;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAll() {
        var user = new User();
        user.setLastName("Valera");
      //  user.setId(UUID 1);
        user.setFirstName("Valera");
        return List.of(user);
    }

    @GetMapping("/{param}")
    public User get(@PathVariable("param") UUID id) {
        var user = new User();
        user.setLastName("Vaka");
        user.setId(id);
        user.setFirstName("Gordon");
        return user;
    }

    @PostMapping
    public void create() {

    }
}
