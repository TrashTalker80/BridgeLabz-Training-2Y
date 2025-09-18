public class BookDemo {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4");
        Book book3 = new Book("1984", "George Orwell", "978-0-452-28423-4");
        
        Book.displayLibraryName();
        System.out.println();
        
        book1.displayBookDetails();
        System.out.println();
        
        book2.displayBookDetails();
        System.out.println();
        
        book3.displayBookDetails();
        System.out.println();
        
        System.out.println("Total books in library: " + Book.getTotalBooks());
        
        System.out.println("\nInstance Check:");
        if (book1 instanceof Book) {
            System.out.println("book1 is an instance of Book class");
            System.out.println("ISBN: " + book1.getIsbn());
        }
        
        Object obj = book2;
        if (obj instanceof Book) {
            System.out.println("obj (book2) is an instance of Book class");
            Book bookObj = (Book) obj;
            System.out.println("Title: " + bookObj.getTitle());
        }
        
        System.out.println("String object is not an instance of Book class");
    }
}

class Book {
    private static String libraryName = "Central Public Library";
    private static int totalBooks = 0;
    
    private String title;
    private String author;
    private final String isbn;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        totalBooks++;
    }
    
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    
    public static int getTotalBooks() {
        return totalBooks;
    }
    
    public void displayBookDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return this.title;
    }
}