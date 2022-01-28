package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dto.UserDto;
import ua.goit.model.User;
import ua.goit.model.UserDevelopers;
import ua.goit.reposetories.UserDevelopersRepository;
import ua.goit.reposetories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        return userRepository.findAll();
//                .stream().peek(user -> {
//                    user.setGroups(Collections.emptyList());   //коли є мані то мані
 //                     user.setOrders(Collections.emptyList());
//                }).collect(Collectors.toList());
    }



}
