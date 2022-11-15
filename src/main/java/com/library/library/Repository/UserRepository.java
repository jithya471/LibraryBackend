package com.library.library.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.library.Model.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    
}
