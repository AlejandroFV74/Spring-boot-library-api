package com.flores.libraryapi.controllers;


import com.flores.libraryapi.entities.Book;
import com.flores.libraryapi.repository.BookRepository;
import com.flores.libraryapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping(params = "author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping(params = "id")
    public Book findByID(@RequestParam String id) {
        return bookService.findByID(id);
    }

    @GetMapping(params = "title")
    public List<Book> findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable String id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping
    public void deleteById(@RequestParam String id) {
        bookService.deleteBook(id);
    }
}
