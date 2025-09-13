import java.util.ArrayList;

public class ShoppingCart {
    private String itemName;
    private double price;
    private int quantity;

    private static ArrayList<ShoppingCart> cart = new ArrayList<>();

    public ShoppingCart(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItemToCart() {
        cart.add(this);
    }

    public void removeItemFromCart() {
        cart.remove(this);
    }

    public static double calculateTotalCost() {
        double total = 0.0;
        for(ShoppingCart item : cart) {
            total += item.price * item.quantity;
        }
        return total;
    }

    public static void displayCartItems() {
        System.out.println("Cart Items:");
        for(ShoppingCart item : cart) {
            System.out.println("- " + item.itemName + " (Price: " + item.price + ", Quantity: " + item.quantity + ")");
        }
    }

    public static void displayCartTotalCost() {
        displayCartItems();
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

class MainShoppingCart {
    public static void main(String[] args) {
        ShoppingCart item1 = new ShoppingCart("Shirt", 500.0, 2);
        ShoppingCart item2 = new ShoppingCart("Pants", 1200.0, 1);
        item1.addItemToCart();
        item2.addItemToCart();
        ShoppingCart.displayCartTotalCost();
        item1.removeItemFromCart();
        System.out.println("\nAfter removing one item:");
        ShoppingCart.displayCartTotalCost();
    }
}