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

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
