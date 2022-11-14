package com.library.library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.library.Model.User;
import com.library.library.Repository.UserRepository;

@Component
public class UserServiceImpl implements UserServiceInterface{
    
    @Autowired
    private UserRepository userRepository;

    @Override
        public List<User> viewUsers(){
            return userRepository.findAll();
        }

    @Override
    public User signUp(User userDetails){
        User user = userRepository.findByEmail(userDetails.getEmail());

        if(user != null){
            return null;
        }
       
         return userRepository.save(userDetails);

        }
        @Override
        public User logIn(User userDetails){
            User user = userRepository.findByEmailAndPassword(userDetails.getEmail(), userDetails.getPassword());
            if(user == null){
                return null;
            }
            return user;
        }
    }

