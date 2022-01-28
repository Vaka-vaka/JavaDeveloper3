package ua.goit.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.goit.dto.UserDto;
import ua.goit.model.User;
import ua.goit.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable UUID id) {
        var user = new User();
        user.setLastName("Vaka");
        user.setFirstName("Gordon");
        return user;
    }

    @PostMapping
    public void create(
           @RequestParam String email,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam String password
    ) {

        System.out.println(email);
        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(password);
    }
}
