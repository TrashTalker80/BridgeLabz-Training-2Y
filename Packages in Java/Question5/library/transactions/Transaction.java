package library.transactions;

import library.books.Book;
import library.members.Member;

public class Transaction {
    private String transactionId;
    private Member member;
    private Book book;
    private String transactionType;

    public void issueBook(String transactionId, Member member, Book book) {
        this.transactionId = transactionId;
        this.member = member;
        this.book = book;
        this.transactionType = "ISSUE";
        
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' issued to " + member.getName());
            System.out.println("Transaction ID: " + transactionId);
        } else {
            System.out.println("Book is not available for issue.");
        }
    }

    public void returnBook(String transactionId, Member member, Book book) {
        this.transactionId = transactionId;
        this.member = member;
        this.book = book;
        this.transactionType = "RETURN";
        
        book.setAvailable(true);
        System.out.println("Book '" + book.getTitle() + "' returned by " + member.getName());
        System.out.println("Transaction ID: " + transactionId);
    }
}
