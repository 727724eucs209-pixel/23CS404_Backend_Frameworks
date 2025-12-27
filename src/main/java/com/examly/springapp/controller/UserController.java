package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<User>> getUserByPagination(@PathVariable int pageNumber, @PathVariable int pageSize){
        Page<User> page = userService.getUserByPagination(pageNumber, pageSize);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/users/role/{role}")
    public ResponseEntity<?> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRole(role);
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found with role: " + role);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with email: " + email);
        }
        return ResponseEntity.ok(user);
    }

}
