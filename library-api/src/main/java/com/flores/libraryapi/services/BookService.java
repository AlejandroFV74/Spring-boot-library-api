package com.flores.libraryapi.services;

import com.flores.libraryapi.repository.BookRepository;
import com.flores.libraryapi.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public Book findByID(String id){
        return bookRepository.findById(id)
                //this makes findById not optional
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book updatedBook) {

        Book existingBook = findByID(id);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setIsbn(updatedBook.getIsbn());

        return bookRepository.save(existingBook);

    }

    public void deleteBook(String id) {
        Book existingBook = findByID(id);
        bookRepository.delete(existingBook);
    }
}
