package dev.fitzgerald.repos;


import dev.fitzgerald.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository //stereotype that says what this component is
//A repository component is sued to perform crud operations with the database
//<Entity, PrimaryKey type>
public interface BookRepo extends JpaRepository<Book, Integer> {


    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String author);

}
