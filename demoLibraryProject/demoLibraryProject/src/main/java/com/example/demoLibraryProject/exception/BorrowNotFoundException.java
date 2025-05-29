package com.example.demoLibraryProject.exception;

public class BorrowNotFoundException extends RuntimeException {
    public BorrowNotFoundException(Long borrowId) {
        super("Borrow record with ID " + borrowId + " not found.");
    }
}
