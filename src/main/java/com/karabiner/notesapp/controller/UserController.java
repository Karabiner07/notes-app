package com.karabiner.notesapp.controller;

import com.karabiner.notesapp.entity.User;
import com.karabiner.notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){

        Map<String, Object> map = new HashMap<>();

        if(userService.existsUserByUserName(user.getUserName())){
            map.put("message", "User Already Exists !!");
            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }

        userService.registerUser(user);
        map.put("message", "Saved Successfully");
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user){

        Map<String, Object> map = new HashMap<>();
        if(userService.existsUserByUserName(user.getUserName())){

            User u = userService.findUserByUserName(user.getUserName());

            if(!user.getUserPass().equals(u.getUserPass())){
                map.put("message", "password did not match");
                return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
            }

            map.put("message", "you are authorized");
            map.put("userId", u.getUserId());

            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        map.put("message", "The username does not exist, please register to continue");
        return new ResponseEntity<>(map, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
