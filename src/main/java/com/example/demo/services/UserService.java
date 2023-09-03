package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateOneUser(int userId, User newUser){
        User userTmp = userRepository.findById(Long.valueOf(userId)).get();
        userTmp.setFirstName(newUser.getFirstName());
        userTmp.setPhoneNumber(newUser.getPhoneNumber());
        userTmp.setAge(newUser.getAge());
        userRepository.save(userTmp);
        return userTmp;
    }

    public void deleteById(int userId) {
        userRepository.deleteById(Long.valueOf(userId));
    }

    public User saveOneUser(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }
}
