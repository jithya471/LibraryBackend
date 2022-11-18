package com.library.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.library.Model.Book;
import com.library.library.Model.PreviousId;
import com.library.library.Repository.BookRepository;
import com.library.library.Repository.PreviousIdRepository;

@Component
public class BookServiceImpl implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PreviousIdRepository previousIdRepository;

    @Override
    public Book addBook(Book bookDetails) {
        Book bookName = bookRepository.findByBookName(bookDetails.getBookName());
        if (bookName != null) {
            return null;
        }

        PreviousId previousId = previousIdRepository.findByType("book");

        Integer previousBookId = previousId.getPreviousId();

        if (previousBookId < 9) {
            bookDetails.setId("BN00" + ++previousBookId);
        } else {
            bookDetails.setId("BN0" + ++previousBookId);
        }
        previousId.setPreviousId(previousBookId);
        previousIdRepository.save(previousId);
        return bookRepository.save(bookDetails);
    }

    public Book editBook(String bookId, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) {
            return null;
        }

        Book bookSaved = optionalBook.get();
        // updating each field
        bookSaved.setBookName(bookDetails.getBookName());
        bookSaved.setAuthor(bookDetails.getAuthor());
        bookSaved.setIsbn(bookDetails.getIsbn());
        bookSaved.setBalCopies(bookDetails.getBalCopies());
        bookSaved.setTotalNo(bookDetails.getTotalNo());
        return bookRepository.save(bookDetails);
    }

    public Boolean delBook(String bookId) {
        if (!bookRepository.existsById(bookId))
            return false;

        bookRepository.deleteById(bookId);
        return true;
    }

    @Override
    public List<Book> viewAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) {
            return null;
        }
        return optionalBook.get();
    }

}
