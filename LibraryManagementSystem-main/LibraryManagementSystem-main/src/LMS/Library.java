package LMS;
import java.util.*;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    Map<Member,Book> connect=new HashMap<>();

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Book added successfully.");
    }

    
    
    public void addMember(Member member) {
        this.members.add(member);
        System.out.println("Member added successfully.");
    }


    public void issueBook(int memberId, int bookId) {
        Member member = findMember(memberId); 
        Book book = findBook(bookId);

        if (member != null && book != null) {
            if (book.isAvailable()) {
                book.setAvailability(false);
                member.borrowBook(book);
                connect.put(member, book);
                
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Issue failed. Check member ID or book ID.");
        }
    }
    

    public void returnBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member != null && book != null) {
            if(!book.isAvailable() && member.getBorrowedBooks().contains(book)) {
                book.setAvailability(true);
                member.returnBook(book);
                connect.remove(member);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Return failed. Book was not issued to this member.");
            }
        } else {
            System.out.println("Return failed. Check member ID or book ID.");
        }
    }

    public void displayAllBooks() {
        System.out.println("All Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void displayBorrowedBooks() {  
    	
    	
        System.out.println("Borrowed Books:"); 
        for (Map.Entry<Member, Book> entry : connect.entrySet()) {
            Member m = entry.getKey(); // Get the Member (key)
            Book b = entry.getValue(); // Get the Book (value)
            System.out.println("Member: " + m.getName() + ", Book: " + b.getTitle());
        }
    }

    public void displayAllMembers() {
        System.out.println("All Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }  
    public void filterAvailableBooksByTitle(String title) {
        System.out.println("Available Books with title: " + title);
        books.stream()
             .filter(book -> book.isAvailable() && book.getTitle().equalsIgnoreCase(title))
             .forEach(System.out::println);
    }
    
    public void searchMembersByBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null) {
            System.out.println("Searching members who borrowed the book: " + book.getTitle());
            boolean found = false;
            for (Member member : members) {
                if (member.getBorrowedBooks().contains(book)) {
                    System.out.println("Member ID: " + member.getMemberId() + ", Name: " + member.getName());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No members have borrowed this book.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    
    

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    private Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
}


