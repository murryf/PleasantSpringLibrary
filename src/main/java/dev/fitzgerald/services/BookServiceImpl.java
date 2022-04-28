package dev.fitzgerald.services;

import dev.fitzgerald.entities.Book;
import dev.fitzgerald.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book registerBook(Book book) {
        book.setReturnDate(0);
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        Optional<Book> possibleBook = this.bookRepo.findById(id);
        if(possibleBook.isPresent()){
            return possibleBook.get();
        }else{
            throw new RuntimeException("No Such book with ID "+id);
        }
    }

    @Override
    public Book checkInBook(Integer id) {
        Book book = this.getBookById(id);
        book.setReturnDate(0);
        this.bookRepo.save(book);
        return null;
    }

    @Override
    public Book checkOutBook(Integer id) {
        Book book = this.getBookById(id);
        book.setReturnDate((System.currentTimeMillis() + (1000*60*24*14)));
        this.bookRepo.save(book);
        return null;
    }
}
