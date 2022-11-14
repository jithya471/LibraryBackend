package com.library.library.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.library.Model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    public Book findByBookName(String bookName);
    
    
}
