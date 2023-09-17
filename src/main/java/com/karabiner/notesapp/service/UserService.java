package com.karabiner.notesapp.service;

import com.karabiner.notesapp.entity.User;

public interface UserService {

    public boolean existsUserByUserName(String userName);

    public User findUserByUserName(String userName);

    public User registerUser(User user);
}
