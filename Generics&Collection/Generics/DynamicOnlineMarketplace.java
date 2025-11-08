import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " [" + category.getCategoryName() + "]";
    }
}

class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public <T extends Category> void addProduct(Product<T> product) {
        products.add(product);
        System.out.println("Added: " + product);
    }

    public void displayCatalog() {
        System.out.println("\nProduct Catalog:");
        for (Product<? extends Category> product : products) {
            System.out.println(" - " + product);
        }
    }
}

public class DynamicOnlineMarketplace {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
        System.out.println("Applied " + percentage + "% discount to " + product.getName());
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 49.99, new BookCategory());
        Product<ClothingCategory> clothing = new Product<>("T-Shirt", 29.99, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<>("Wireless Mouse", 19.99, new GadgetCategory());

        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(clothing);
        catalog.addProduct(gadget);

        System.out.println();

        applyDiscount(book, 10);
        applyDiscount(clothing, 20);
        applyDiscount(gadget, 15);

        catalog.displayCatalog();
    }
}
