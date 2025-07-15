package com.example.restcontroller_demo.service;

import org.springframework.stereotype.Service;
import com.example.restcontroller_demo.model.User;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Integer, User> userDB = new HashMap<>();

    public User getUser(int id) {
        return userDB.getOrDefault(id, new User(id, "User_Not_Found"));
    }

    public String saveUser(User user) {
        userDB.put(user.getId(), user);
        return "Saved user: " + user.getName();
    }

    public String updateUser(User user) {
        userDB.put(user.getId(), user);
        return "Updated user: " + user.getName();
    }

    public String deleteUser(int id) {
        userDB.remove(id);
        return "Deleted user with ID: " + id;
    }
}
