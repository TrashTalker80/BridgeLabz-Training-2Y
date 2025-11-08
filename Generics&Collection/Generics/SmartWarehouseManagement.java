import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private int quantity;

    public WarehouseItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + " (Quantity: " + quantity + ")";
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name, int quantity) {
        super(name, quantity);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, int quantity) {
        super(name, quantity);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, int quantity) {
        super(name, quantity);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item);
    }

    public void displayItems() {
        System.out.println("Storage contains:");
        for (T item : items) {
            System.out.println(" - " + item);
        }
    }

    public List<T> getItems() {
        return items;
    }
}

public class SmartWarehouseManagement {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("All warehouse items:");
        for (WarehouseItem item : items) {
            System.out.println(" - " + item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 50));
        electronicsStorage.addItem(new Electronics("Smartphone", 100));
        electronicsStorage.displayItems();

        System.out.println();

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice", 200));
        groceriesStorage.addItem(new Groceries("Wheat", 150));
        groceriesStorage.displayItems();

        System.out.println();

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 30));
        furnitureStorage.addItem(new Furniture("Table", 20));
        furnitureStorage.displayItems();

        System.out.println();

        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.addAll(electronicsStorage.getItems());
        allItems.addAll(groceriesStorage.getItems());
        allItems.addAll(furnitureStorage.getItems());
        displayAllItems(allItems);
    }
}
