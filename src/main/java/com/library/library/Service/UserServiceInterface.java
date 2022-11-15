package com.library.library.Service;

import java.util.List;

import com.library.library.Model.User;

interface UserServiceInterface {
    public abstract List<User> viewUsers();
    public abstract User signUp(User userDetails);
    public abstract User logIn(User userDetails);
    public abstract User singleUser(String userId);
    
}
