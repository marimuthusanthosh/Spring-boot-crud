package com.example.demoLibraryProject.model;

import java.time.LocalDate;

public class Borrow {
    private Long id;
    private Long memberId;
    private Long bookId;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private Book book;
    private Member member;

    public Borrow() {
    }

    public Borrow(Long id, Long memberId, Long bookId, LocalDate borrowedDate, LocalDate dueDate, Book book, Member member) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.book = book;
        this.member = member;
    }

    public Borrow(Long id, Long memberId, Long bookId, LocalDate borrowedDate, LocalDate dueDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowedDate() {
        return this.borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
