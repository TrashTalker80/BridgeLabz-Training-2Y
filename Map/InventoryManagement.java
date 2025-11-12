import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        
        inventory.put("Laptop", 50);
        inventory.put("Mouse", 100);
        inventory.put("Keyboard", 75);
        
        String purchaseProduct = "Mouse";
        int purchaseQuantity = 20;
        if (inventory.containsKey(purchaseProduct)) {
            int currentQuantity = inventory.get(purchaseProduct);
            int newQuantity = currentQuantity - purchaseQuantity;
            if (newQuantity > 0) {
                inventory.put(purchaseProduct, newQuantity);
            } else {
                inventory.remove(purchaseProduct);
            }
        }
        
        String shipmentProduct = "Laptop";
        int shipmentQuantity = 30;
        inventory.put(shipmentProduct, inventory.getOrDefault(shipmentProduct, 0) + shipmentQuantity);
        
        String queryProduct = "Phone";
        if (inventory.containsKey(queryProduct)) {
            System.out.println(queryProduct + ": " + inventory.get(queryProduct) + " units");
        } else {
            System.out.println(queryProduct + ": not stocked");
        }
        
        System.out.println("\nOut of Stock Products:");
        boolean hasOutOfStock = false;
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
                hasOutOfStock = true;
            }
        }
        if (!hasOutOfStock) {
            System.out.println("None");
        }
        
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
