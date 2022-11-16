package com.library.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Model.User;
import com.library.library.Service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public User signUp(@RequestBody User userDetails){
        return userServiceImpl.signUp(userDetails);
    }

    @PostMapping("/login")
    public User logIn(@RequestBody User userDetails){
        return userServiceImpl.logIn(userDetails);
    }

    @GetMapping("/all-users")
    public List<User> viewUsers(){
        return userServiceImpl.viewUsers();
    }

    @PutMapping("/checkout/{userId}/{bookId}")
    public User checkOut(@PathVariable("userId") String userId, @PathVariable("bookId") String bookId ){
        return userServiceImpl.checkOut(userId, bookId);
    }
}
