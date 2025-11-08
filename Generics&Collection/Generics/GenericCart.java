import java.util.ArrayList;
import java.util.List;

class Electronics {
    private String name;

    public Electronics(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Electronics: " + name;
    }
}

class Clothing {
    private String name;

    public Clothing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clothing: " + name;
    }
}

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book: " + title;
    }
}

class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        System.out.println("Cart contents:");
        for (T item : items) {
            System.out.println(" - " + item);
        }
    }
}

public class GenericCart {
    public static void main(String[] args) {
        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Phone"));
        electronicsCart.displayItems();

        System.out.println();

        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));
        clothingCart.displayItems();

        System.out.println();

        Cart<Book> bookCart = new Cart<>();
        bookCart.addItem(new Book("Java Programming"));
        bookCart.addItem(new Book("Design Patterns"));
        bookCart.displayItems();
    }
}
