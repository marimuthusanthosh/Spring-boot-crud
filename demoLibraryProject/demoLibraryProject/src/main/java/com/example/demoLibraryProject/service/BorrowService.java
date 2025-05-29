
package com.example.demoLibraryProject.service;

import com.example.demoLibraryProject.model.Borrow;
import com.example.demoLibraryProject.repository.BorrowRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<Borrow> getAll() {
        return this.borrowRepository.findAll();
    }

    public Borrow getById(Long id) {
        return this.borrowRepository.findById(id);
    }

    public void borrowBook(Borrow borrow) {
        this.borrowRepository.save(borrow);
    }

    public void returnBook(Long id) {
        this.borrowRepository.returnBook(id);
    }
}
