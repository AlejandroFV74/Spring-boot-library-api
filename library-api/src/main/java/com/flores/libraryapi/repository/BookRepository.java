package com.flores.libraryapi.repository;

import com.flores.libraryapi.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    Book findById(long id);
    List<Book> deleteBookById(long id);
}
