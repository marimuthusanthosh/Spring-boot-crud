package com.example.demoLibraryProject.controller;

import com.example.demoLibraryProject.model.Book;
import com.example.demoLibraryProject.service.BookService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/books"})
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.service.getAllBooks();
    }

    @GetMapping({"/{id}"})
    public Book getBook(@PathVariable Long id) {
        return this.service.getBookById(id);
    }

    @PostMapping({"/add"})
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = this.service.createBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updated = this.service.updateBook(id, book);
        return ResponseEntity.status(201).body(updated);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        this.service.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted Succesfully");
    }

    @GetMapping({"/search"})
    public List<Book> searchBooks(@RequestParam("q") String query) {
        return this.service.searchBooks(query);
    }
}
