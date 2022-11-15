package com.library.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Model.Book;
import com.library.library.Service.BookServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;
    
    @PostMapping("/addbooks")
    public Book addBook(@RequestBody Book bookDetails){
        return bookServiceImpl.addBook(bookDetails);
    }

    @PatchMapping("/edit/id/{id}")
    public Book editBook(@PathVariable("id") String id, @RequestBody Book editBookDetails){
        return bookServiceImpl.editBook(id, editBookDetails); 
    }

    @DeleteMapping("/deletebook/{id}")
    public Boolean delBook(@PathVariable("id") String bookId){
        return bookServiceImpl.delBook(bookId);
    }

    @GetMapping("/view")
    public List<Book> viewAllBooks(){
        return bookServiceImpl.viewAllBooks();
    }

    @GetMapping("/getbook/{id}")
    public Book getBook(@PathVariable("id") String bookId){
        return bookServiceImpl.getBook(bookId);
    }
}
