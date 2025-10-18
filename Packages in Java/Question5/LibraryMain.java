import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class LibraryMain {
    public static void main(String[] args) {
        Book book = new Book("B001", "Java Programming", "James Gosling");
        System.out.println("Adding a new book:");
        book.displayBookDetails();
        
        System.out.println("\n----------------------------\n");
        
        Member member = new Member("M001", "Emma Watson", "9876543210");
        System.out.println("Registering a new member:");
        member.displayMemberDetails();
        
        System.out.println("\n----------------------------\n");
        
        Transaction transaction = new Transaction();
        System.out.println("Issuing book to member:");
        transaction.issueBook("T001", member, book);
    }
}
