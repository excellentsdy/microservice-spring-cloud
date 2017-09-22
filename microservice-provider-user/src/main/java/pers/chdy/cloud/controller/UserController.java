package pers.chdy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.chdy.cloud.entity.User;
import pers.chdy.cloud.repository.UserRepository;

/**
 * CreteTime:2017/9/7 10:12.
 *
 * @author chdy
 */

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @PostMapping(path = "/user")
    public User postUser(@RequestBody User user){
        return user;
    }
    @GetMapping(path = "/get-user")
    public User getUser(User user){
        return user;
    }
}
