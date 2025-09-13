public class ItemInventory {
    private String itemCode;
    private String itemName;
    private double price;

    public ItemInventory(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

class MainItemInventory {
    public static void main(String[] args) {
        ItemInventory item = new ItemInventory("I101", "Laptop", 75000.0);
        item.displayItemDetails();
        System.out.println("Total Cost for 3 items: " + item.calculateTotalCost(3));
    }
}