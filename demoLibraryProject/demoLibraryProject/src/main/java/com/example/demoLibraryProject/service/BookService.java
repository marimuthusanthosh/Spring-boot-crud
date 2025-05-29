package com.example.demoLibraryProject.service;

import com.example.demoLibraryProject.model.Book;
import com.example.demoLibraryProject.repository.BookRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return this.repository.findAll();
    }

    public Book getBookById(Long id) {
        return (Book)this.repository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Book not found");
        });
    }

    public Book createBook(Book book) {
       Long id= this.repository.save(book);
       book.setId(id);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        this.repository.update(id, book);
        book.setId(id);
        return book;
    }

    public void deleteBook(Long id) {
        this.repository.delete(id);
    }

    public List<Book> searchBooks(String keyword) {
        return this.repository.search(keyword);
    }
}
