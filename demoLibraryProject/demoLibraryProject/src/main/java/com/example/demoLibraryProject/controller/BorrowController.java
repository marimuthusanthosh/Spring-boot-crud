package com.example.demoLibraryProject.controller;

import com.example.demoLibraryProject.model.Borrow;
import com.example.demoLibraryProject.service.BorrowService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/borrows"})
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        return ResponseEntity.ok(this.borrowService.getAll());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        return ResponseEntity.ok(this.borrowService.getById(id));
    }

    @PostMapping({"/add"})
    public ResponseEntity<Void> borrowBook(@RequestBody Borrow borrow) {
        this.borrowService.borrowBook(borrow);
        return ResponseEntity.ok().build();
    }

    @PutMapping({"/{id}/return"})
    public ResponseEntity<Void> returnBook(@PathVariable Long id) {
        this.borrowService.returnBook(id);
        return ResponseEntity.ok().build();
    }
}
