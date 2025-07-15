package com.example.restcontroller_demo.controller;

import com.example.restcontroller_demo.model.User;
import com.example.restcontroller_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        return "Updated user: " + user.getName();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return "Deleted user with ID: " + id;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Spring Boot Web + REST Controller Demo";
    }
}
