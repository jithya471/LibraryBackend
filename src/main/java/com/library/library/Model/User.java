package com.library.library.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String userName;
    private String address;
    private String dob;
    private String email;
    private String gender;
    private String password;
    private String role;
    
}
