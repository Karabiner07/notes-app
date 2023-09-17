package com.karabiner.notesapp.service;

import com.karabiner.notesapp.entity.User;
import com.karabiner.notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existsUserByUserName(String userName) {
        return userRepository.existsUserByUserName(userName);
    }

    @Override
    public boolean existsUserByUserPass(String userPass) {
        return userRepository.existsUserByUserPass(userPass);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}