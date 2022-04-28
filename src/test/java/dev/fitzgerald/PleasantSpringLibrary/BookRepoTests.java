package dev.fitzgerald.PleasantSpringLibrary;

import dev.fitzgerald.entities.Book;
import dev.fitzgerald.repos.BookRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest // Let spring know that this test file will use spring
public class BookRepoTests {
    @Autowired
    private BookRepo bookRepo;

    @Test
    public void createBook(){
        Book book = new Book(0,"Fankenstien", "Mary Shelly", 0);
        bookRepo.save(book);
        System.out.println(book);
        Assertions.assertNotEquals(0, book.getId());

    }
    @Test
    public void getAllBooks(){
        List<Book> books = this.bookRepo.findAll();
        System.out.println(books);
    }

    @Test
    public void getBookById() {
        Optional<Book> possibleBook = this.bookRepo.findById(51);
        if(possibleBook.isPresent()){
            Book book = possibleBook.get();
            System.out.println(book);
        } else {
            System.out.println("No book was returned");
        }
    }
    @Test
    public void  findBooksByTitle() {
        List<Book> frankenstiens = this.bookRepo.findBooksByTitle("Frankenstien");
        System.out.println(frankenstiens);

    }

    @Test
    public void findBooksAuthor(){
        List<Book> frankenstiens = this.bookRepo.findBooksByAuthor("Mary Shelly");
        System.out.println(frankenstiens);
    }

}
