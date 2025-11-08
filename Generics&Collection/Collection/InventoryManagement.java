import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void restock(int amount) {
        this.stock += amount;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ", Stock: " + stock + ")";
    }
}

public class InventoryManagement {
    private Set<String> uniqueProductNames;
    private List<Product> allProducts;
    private Queue<Product> restockQueue;
    private Stack<Product> recentlyRestocked;

    public InventoryManagement() {
        uniqueProductNames = new HashSet<>();
        allProducts = new ArrayList<>();
        restockQueue = new LinkedList<>();
        recentlyRestocked = new Stack<>();
    }

    public void addProduct(Product product) {
        if (uniqueProductNames.add(product.getName())) {
            allProducts.add(product);
            System.out.println("Product added: " + product);
        } else {
            System.out.println("Product already exists: " + product.getName());
        }
    }

    public void identifyLowStock() {
        System.out.println("\nLow stock items:");
        for (Product product : allProducts) {
            if (product.getStock() < 10) {
                restockQueue.add(product);
                System.out.println(product);
            }
        }
    }

    public void processRestocking() {
        System.out.println("\nRestocking:");
        while (!restockQueue.isEmpty()) {
            Product product = restockQueue.poll();
            product.restock(50);
            recentlyRestocked.push(product);
            System.out.println("Restocked: " + product);
        }
    }

    public void undoLastRestock() {
        if (!recentlyRestocked.isEmpty()) {
            Product product = recentlyRestocked.pop();
            System.out.println("\nUndo restock: " + product);
        }
    }

    public static void main(String[] args) {
        InventoryManagement system = new InventoryManagement();

        system.addProduct(new Product("Laptop", 1000, 5));
        system.addProduct(new Product("Mouse", 20, 15));
        system.addProduct(new Product("Keyboard", 50, 3));

        system.identifyLowStock();
        system.processRestocking();
        system.undoLastRestock();
    }
}
