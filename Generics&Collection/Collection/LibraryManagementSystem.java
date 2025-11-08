import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Book {
    private String bookId;
    private String title;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    @Override
    public String toString() {
        return bookId + " - " + title;
    }
}

public class LibraryManagementSystem {
    private List<Book> allBooks;
    private Set<String> memberIds;
    private Queue<Book> issuanceQueue;
    private Stack<Book> returnedBooks;

    public LibraryManagementSystem() {
        allBooks = new ArrayList<>();
        memberIds = new HashSet<>();
        issuanceQueue = new LinkedList<>();
        returnedBooks = new Stack<>();
    }

    public void addBook(Book book) {
        allBooks.add(book);
        System.out.println("Book added: " + book);
    }

    public void registerMember(String memberId) {
        if (memberIds.add(memberId)) {
            System.out.println("Member registered: " + memberId);
        } else {
            System.out.println("Member already registered: " + memberId);
        }
    }

    public void queueForIssuance(Book book) {
        issuanceQueue.add(book);
        System.out.println("Queued for issuance: " + book);
    }

    public void issueBooks() {
        System.out.println("\nIssuing books:");
        while (!issuanceQueue.isEmpty()) {
            Book book = issuanceQueue.poll();
            System.out.println("Issued: " + book);
        }
    }

    public void returnBook(Book book) {
        returnedBooks.push(book);
        System.out.println("\nReturned: " + book);
    }

    public void reIssueLastReturned() {
        if (!returnedBooks.isEmpty()) {
            Book book = returnedBooks.pop();
            System.out.println("Re-issuing: " + book);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook(new Book("B001", "Java Programming"));
        library.addBook(new Book("B002", "Data Structures"));

        library.registerMember("M001");
        library.registerMember("M002");
        library.registerMember("M001");

        library.queueForIssuance(new Book("B001", "Java Programming"));
        library.issueBooks();
        library.returnBook(new Book("B001", "Java Programming"));
        library.reIssueLastReturned();
    }
}
