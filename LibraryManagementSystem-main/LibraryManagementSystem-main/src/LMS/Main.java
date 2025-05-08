package LMS;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display Available Books");
            System.out.println("7. Display Borrowed Books");
            System.out.println("8. Display Members");
            System.out.println("9. Exit");
            System.out.println("10. searchbook");
            System.out.println("11. Search Members by Book ID");

            System.out.print("Enter choice: ");  

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author, genre, true));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    library.addMember(new Member(memberId, name, contact));
                    System.out.println("Member added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    int issueMemberId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int issueBookId = scanner.nextInt();
                    library.issueBook(issueMemberId, issueBookId);
                    System.out.println("book issued successfully!");

                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    int returnMemberId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int returnBookId = scanner.nextInt();
                    library.returnBook(returnMemberId, returnBookId);
                    break;

                case 5:
                    library.displayAllBooks();
                    break;

                case 6:
                    library.displayAvailableBooks();
                    break;

                case 7:
                    library.displayBorrowedBooks();
                    break;

                case 8:
                    library.displayAllMembers();
                    break;
                case 10:
                	System.out.println("Enter the book title");
                	String searchTitle=scanner.nextLine(); 
                	library.filterAvailableBooksByTitle(searchTitle);
                	break;  
                case 11:
                	System.out.println("Enter the member name of books borrowed");
                	int searchbookid=scanner.nextInt(); 
                	library.searchMembersByBook(searchbookid); 
                	break;

                case 9:
                    System.out.println("Exiting... Thank you for using Library Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }
}
