package dev.fitzgerald.controllers;


import dev.fitzgerald.entities.Book;
import dev.fitzgerald.services.BookService;
import dev.fitzgerald.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@Controller
public class BookController {

    @Autowired
    private BookService bookService = new BookServiceImpl();

    @GetMapping("/books")  //Spring will generate a route /books that when
    @ResponseBody // Converts the return into a JSON for the HTTP service
    public List<Book> retrieveAllBooks() {
        List<Book> books = this.bookService.getAllBooks();
        return books;
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable Integer id){
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    @ResponseBody
    public Book createBook(@RequestBody Book book) {
        return this.bookService.registerBook(book);
    }

    @PatchMapping("/books/{id}/checkout")
    @ResponseBody
    public Book checkoutBook(@PathVariable Integer id) {
        return bookService.checkOutBook(id);

    }
}
