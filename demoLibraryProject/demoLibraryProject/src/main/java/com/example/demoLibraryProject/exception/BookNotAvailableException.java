
package com.example.demoLibraryProject.exception;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(Long bookId) {
        super("Book with ID " + bookId + " is currently unavailable.");
    }
}
