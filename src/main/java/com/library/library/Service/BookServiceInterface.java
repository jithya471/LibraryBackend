package com.library.library.Service;

import java.util.List;

import com.library.library.Model.Book;

interface BookServiceInterface {
    public abstract Book addBook(Book bookDetails);
    public abstract Boolean delBook(String bookId);
    public abstract Book editBook(String bookId, Book bookDetails);
    public abstract List<Book> viewAllBooks();
    public abstract Book getBook(String bookId);

}
