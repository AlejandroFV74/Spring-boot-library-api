package com.flores.libraryapi.controllers;


import com.flores.libraryapi.entities.Book;
import com.flores.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping(params = "author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }

    @GetMapping(params = "id")
    public Book findByID(@RequestParam long id) {
        return bookRepository.findById(id);
    }

    @GetMapping(params = "title")
    public List<Book> findByTitle(@RequestParam String title) {
        return bookRepository.findByTitle(title);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(id);

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        book.setPrice(updatedBook.getPrice());

        return bookRepository.save(book);
    }

    @DeleteMapping
    public List<Book> deleteById(@RequestParam long id) {
        return bookRepository.deleteBookById(id);
    }
}
