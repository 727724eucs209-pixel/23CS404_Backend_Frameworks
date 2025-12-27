package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(long userId, User user){
        User existingUser = userRepo.findById(userId).orElse(null);
        if(existingUser != null){
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setFullName(user.getFullName());
            existingUser.setRole(user.getRole());
            
            return userRepo.save(existingUser);
        }
        return null;
    }

    public User newUser(User user){
        return userRepo.save(user);
    }

    public User getUserById(long userId){
        return userRepo.findById(userId).orElse(null);
    }

    public Page<User> getUserByPagination(int pageNumber, int pageSize){
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        return userRepo.findAll(pageable);
    }
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        return user.orElse(null);
    }

}
