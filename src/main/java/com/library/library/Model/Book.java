package com.library.library.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "book") 

public class Book {
    @Id
    private String id;
    private String isbn;
    private String bookName;
    private String author;
    private String totalNo;
    private String balCopies;
    private String image;
    private String role;
}
