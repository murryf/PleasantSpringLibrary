package dev.fitzgerald.services;

import dev.fitzgerald.entities.Book;

import java.util.List;

public interface BookService {

    Book registerBook(Book book);

    List<Book> getAllBooks();
    Book getBookById(Integer id);

    Book checkInBook(Integer id);
    Book checkOutBook(Integer id);



}
