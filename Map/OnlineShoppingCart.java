import java.util.LinkedHashMap;
import java.util.Map;

public class OnlineShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> cart = new LinkedHashMap<>();
        
        cart.put("Laptop", 45000.0);
        cart.put("Mouse", 500.0);
        cart.put("Keyboard", 1500.0);
        cart.put("Monitor", 8000.0);
        cart.put("Headphones", 2000.0);
        
        System.out.println("Shopping Cart (insertion order):");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        double totalBill = 0;
        for (double price : cart.values()) {
            totalBill += price;
        }
        
        System.out.println("\nTotal Bill: " + totalBill);
        
        if (totalBill > 5000) {
            double discount = totalBill * 0.10;
            totalBill -= discount;
            System.out.println("Discount Applied (10%): " + discount);
            System.out.println("Final Bill: " + totalBill);
        }
        
        cart.remove("Mouse");
        
        System.out.println("\nCart after removing item:");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
