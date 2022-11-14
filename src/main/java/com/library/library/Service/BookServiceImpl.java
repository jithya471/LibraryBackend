package com.library.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.library.Model.Book;
import com.library.library.Repository.BookRepository;

@Component
public class BookServiceImpl implements BookServiceInterface{
    
    @Autowired
    public BookRepository bookRepository;

    @Override
    public Book addBook(Book bookDetails){
        Book bookName = bookRepository.findByBookName(bookDetails.getBookName());
        if(bookName != null){
            return null;
        }

        return bookRepository.save(bookDetails);
    }

        public Book editBook(String bookId, Book bookDetails) {
            Optional<Book> optionalBook = bookRepository.findById(bookId);
            Book book =optionalBook.get();
            if(book == null){
                return null;
            }

            book.setBookName(bookDetails.getBookName());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setBalCopies(bookDetails.getBalCopies());
            book.setTotalNo(bookDetails.getTotalNo());
            return bookRepository.save(bookDetails);
        }

        public Boolean delBook(String bookId){
            if(!bookRepository.existsById(bookId))
                return false;
            
                bookRepository.deleteById(bookId);
                return true;
        }

        @Override
        public List<Book> viewAllBooks(){
            return bookRepository.findAll();
        }

        @Override
        public Book getBook(String bookId){
            Optional<Book> optionalBook = bookRepository.findById(bookId);
            if(!optionalBook.isPresent()){
                return null;
            }
            return optionalBook.get();
        }
        
}
