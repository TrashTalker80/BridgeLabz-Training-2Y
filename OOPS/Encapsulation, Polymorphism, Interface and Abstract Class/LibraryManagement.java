import java.util.*;

interface Reservable {
    boolean reserveItem(String memberId);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrowerId;
    private Date dueDate;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrowerId = null;
        this.dueDate = null;
    }
    
    public abstract int getLoanDuration();
    
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isAvailable ? "Available" : "Borrowed"));
        if (!isAvailable) {
            System.out.println("Borrower ID: " + maskBorrowerId());
            System.out.println("Due Date: " + dueDate);
        }
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
    
    private String maskBorrowerId() {
        if (borrowerId == null || borrowerId.length() <= 3) {
            return borrowerId;
        }
        return borrowerId.substring(0, 3) + "***";
    }
    
    public boolean borrowItem(String memberId) {
        if (isAvailable) {
            isAvailable = false;
            borrowerId = memberId;
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, getLoanDuration());
            dueDate = calendar.getTime();
            return true;
        }
        return false;
    }
    
    public boolean returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            borrowerId = null;
            dueDate = null;
            return true;
        }
        return false;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    protected void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    public String getBorrowerId() {
        return borrowerId;
    }
    
    protected void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }
}

class Book extends LibraryItem implements Reservable {
    private String isbn;
    private int numberOfPages;
    private static final int BOOK_LOAN_DURATION = 21;
    private String reservedBy;
    
    public Book(String itemId, String title, String author, String isbn, int numberOfPages) {
        super(itemId, title, author);
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.reservedBy = null;
    }
    
    @Override
    public int getLoanDuration() {
        return BOOK_LOAN_DURATION;
    }
    
    @Override
    public boolean reserveItem(String memberId) {
        if (!isAvailable() && reservedBy == null) {
            reservedBy = memberId;
            System.out.println("Book reserved successfully for member: " + memberId);
            return true;
        } else if (reservedBy != null) {
            System.out.println("Book is already reserved by another member");
            return false;
        } else {
            System.out.println("Book is available for immediate borrowing");
            return false;
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable() && reservedBy == null;
    }
    
    @Override
    public boolean returnItem() {
        boolean result = super.returnItem();
        if (result && reservedBy != null) {
            System.out.println("Notification: Book is now available for reserved member: " + reservedBy);
        }
        return result;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getNumberOfPages() {
        return numberOfPages;
    }
    
    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages > 0) {
            this.numberOfPages = numberOfPages;
        }
    }
}

class Magazine extends LibraryItem implements Reservable {
    private String issueNumber;
    private String publisher;
    private static final int MAGAZINE_LOAN_DURATION = 7;
    
    public Magazine(String itemId, String title, String author, String issueNumber, String publisher) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
    
    @Override
    public int getLoanDuration() {
        return MAGAZINE_LOAN_DURATION;
    }
    
    @Override
    public boolean reserveItem(String memberId) {
        System.out.println("Magazines cannot be reserved");
        return false;
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    public String getIssueNumber() {
        return issueNumber;
    }
    
    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

class DVD extends LibraryItem {
    private int duration;
    private String genre;
    private static final int DVD_LOAN_DURATION = 14;
    
    public DVD(String itemId, String title, String author, int duration, String genre) {
        super(itemId, title, author);
        this.duration = duration;
        this.genre = genre;
    }
    
    @Override
    public int getLoanDuration() {
        return DVD_LOAN_DURATION;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        }
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        List<LibraryItem> libraryItems = new ArrayList<>();
        
        Book book1 = new Book("BK001", "Java Programming", "James Gosling", "978-0134685991", 680);
        Book book2 = new Book("BK002", "Design Patterns", "Gang of Four", "978-0201633610", 395);
        
        Magazine magazine1 = new Magazine("MG001", "Tech Today", "Various", "Issue-202", "Tech Publications");
        Magazine magazine2 = new Magazine("MG002", "Science Weekly", "Editorial Team", "Vol-45", "Science Press");
        
        DVD dvd1 = new DVD("DVD001", "Clean Code Tutorial", "Robert Martin", 240, "Educational");
        DVD dvd2 = new DVD("DVD002", "Algorithm Masterclass", "Donald Knuth", 180, "Educational");
        
        libraryItems.add(book1);
        libraryItems.add(book2);
        libraryItems.add(magazine1);
        libraryItems.add(magazine2);
        libraryItems.add(dvd1);
        libraryItems.add(dvd2);
        
        System.out.println("=== Library Management System ===\n");
        
        System.out.println("--- Library Inventory ---");
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Can be reserved: Yes");
            }
            System.out.println("-------------------");
        }
        
        System.out.println("\n--- Library Operations ---");
        
        if (book1.borrowItem("MEM001")) {
            System.out.println("Book '" + book1.getTitle() + "' borrowed successfully");
        }
        
        book1.reserveItem("MEM002");
        
        if (magazine1.borrowItem("MEM003")) {
            System.out.println("Magazine '" + magazine1.getTitle() + "' borrowed successfully");
        }
        
        magazine1.reserveItem("MEM004");
        
        if (dvd1.borrowItem("MEM005")) {
            System.out.println("DVD '" + dvd1.getTitle() + "' borrowed successfully");
        }
        
        System.out.println("\n--- Return Operations ---");
        book1.returnItem();
        
        System.out.println("\n--- Updated Library Status ---");
        int availableCount = 0;
        int borrowedCount = 0;
        
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("-------------------");
            
            if (item.isAvailable()) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }
        
        System.out.println("\n=== Library Summary ===");
        System.out.println("Total Items: " + libraryItems.size());
        System.out.println("Available Items: " + availableCount);
        System.out.println("Borrowed Items: " + borrowedCount);
        System.out.println("Books: " + libraryItems.stream().filter(item -> item instanceof Book).count());
        System.out.println("Magazines: " + libraryItems.stream().filter(item -> item instanceof Magazine).count());
        System.out.println("DVDs: " + libraryItems.stream().filter(item -> item instanceof DVD).count());
    }
}