import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    private String name;
    private double price;
    private double rating;
    private double discount;
    
    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getRating() {
        return rating;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s | Price: $%.2f | Rating: %.1f | Discount: %.0f%%", 
                           name, price, rating, discount);
    }
}

public class CustomSortingECommerce {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 899.99, 4.5, 10.0));
        products.add(new Product("Smartphone", 699.99, 4.7, 15.0));
        products.add(new Product("Tablet", 399.99, 4.2, 20.0));
        products.add(new Product("Headphones", 149.99, 4.8, 5.0));
        products.add(new Product("Smartwatch", 249.99, 4.3, 12.0));
        
        System.out.println("E-Commerce Product Sorting");
        System.out.println("==========================\n");
        
        System.out.println("Original Product List:");
        products.forEach(System.out::println);
        
        System.out.println("\n--- Sorted by Price (Low to High) ---");
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        products.forEach(System.out::println);
        
        System.out.println("\n--- Sorted by Rating (High to Low) ---");
        products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
        products.forEach(System.out::println);
        
        System.out.println("\n--- Sorted by Discount (High to Low) ---");
        products.sort((p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()));
        products.forEach(System.out::println);
        
        System.out.println("\n--- Sorted by Price (Using Comparator.comparing) ---");
        products.sort(Comparator.comparing(Product::getPrice));
        products.forEach(System.out::println);
    }
}
