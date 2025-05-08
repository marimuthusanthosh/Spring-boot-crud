package LMS;

import java.util.ArrayList;

public class Member {

    private int memberId;
    private String name;
    private String contact;
    private ArrayList<Book> borrowedBooks;

    public Member(int memberId, String name, String contact) {
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
        this.borrowedBooks = new ArrayList<>(); // Initialize borrowed books here
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", contact=" + contact + 
               ", borrowedBooks=" + borrowedBooks.size() + "]";
    }
}
