import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public abstract double calculateTotalPrice();
    
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Unit Price: $" + String.format("%.2f", price));
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + String.format("%.2f", calculateTotalPrice()));
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }
}

class VegItem extends FoodItem implements Discountable {
    private boolean isOrganic;
    private String prepTime;
    private static final double VEG_DISCOUNT_RATE = 0.10;
    private static final double ORGANIC_DISCOUNT_BONUS = 0.05;
    
    public VegItem(String itemName, double price, int quantity, boolean isOrganic, String prepTime) {
        super(itemName, price, quantity);
        this.isOrganic = isOrganic;
        this.prepTime = prepTime;
    }
    
    @Override
    public double calculateTotalPrice() {
        double baseTotal = getPrice() * getQuantity();
        double discount = applyDiscount();
        return baseTotal - discount;
    }
    
    @Override
    public double applyDiscount() {
        double discountRate = VEG_DISCOUNT_RATE;
        if (isOrganic) {
            discountRate += ORGANIC_DISCOUNT_BONUS;
        }
        return getPrice() * getQuantity() * discountRate;
    }
    
    @Override
    public String getDiscountDetails() {
        double discountRate = VEG_DISCOUNT_RATE + (isOrganic ? ORGANIC_DISCOUNT_BONUS : 0);
        return "Veg Item Discount: " + (discountRate * 100) + "%" + 
               (isOrganic ? " (includes organic bonus)" : "");
    }
    
    public boolean isOrganic() {
        return isOrganic;
    }
    
    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }
    
    public String getPrepTime() {
        return prepTime;
    }
    
    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private String meatType;
    private boolean isHalal;
    private static final double NON_VEG_DISCOUNT_RATE = 0.05;
    private static final double HANDLING_CHARGE = 2.0;
    
    public NonVegItem(String itemName, double price, int quantity, String meatType, boolean isHalal) {
        super(itemName, price, quantity);
        this.meatType = meatType;
        this.isHalal = isHalal;
    }
    
    @Override
    public double calculateTotalPrice() {
        double baseTotal = getPrice() * getQuantity();
        double discount = applyDiscount();
        double additionalCharge = HANDLING_CHARGE * getQuantity();
        return baseTotal - discount + additionalCharge;
    }
    
    @Override
    public double applyDiscount() {
        return getPrice() * getQuantity() * NON_VEG_DISCOUNT_RATE;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + (NON_VEG_DISCOUNT_RATE * 100) + "%" +
               " (Additional handling charge: $" + HANDLING_CHARGE + " per item)";
    }
    
    public String getMeatType() {
        return meatType;
    }
    
    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }
    
    public boolean isHalal() {
        return isHalal;
    }
    
    public void setHalal(boolean halal) {
        isHalal = halal;
    }
}

class Order {
    private String orderId;
    private List<FoodItem> items;
    private String customerName;
    private String deliveryAddress;
    private static final double DELIVERY_CHARGE = 5.0;
    private static final double TAX_RATE = 0.08;
    
    public Order(String orderId, String customerName, String deliveryAddress) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.items = new ArrayList<>();
    }
    
    public void addItem(FoodItem item) {
        items.add(item);
    }
    
    public double calculateOrderTotal() {
        double subtotal = 0;
        for (FoodItem item : items) {
            subtotal += item.calculateTotalPrice();
        }
        double tax = subtotal * TAX_RATE;
        return subtotal + tax + DELIVERY_CHARGE;
    }
    
    public void displayOrderDetails() {
        System.out.println("\n=== Order Details ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Delivery Address: " + maskAddress(deliveryAddress));
        System.out.println("\nItems:");
        
        double subtotal = 0;
        double totalDiscount = 0;
        
        for (FoodItem item : items) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                System.out.println(discountableItem.getDiscountDetails());
                totalDiscount += discountableItem.applyDiscount();
            }
            subtotal += item.calculateTotalPrice();
            System.out.println("---");
        }
        
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax + DELIVERY_CHARGE;
        
        System.out.println("\n--- Order Summary ---");
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Total Discount: $" + String.format("%.2f", totalDiscount));
        System.out.println("Tax (8%): $" + String.format("%.2f", tax));
        System.out.println("Delivery Charge: $" + String.format("%.2f", DELIVERY_CHARGE));
        System.out.println("Grand Total: $" + String.format("%.2f", total));
    }
    
    private String maskAddress(String address) {
        if (address == null || address.length() <= 10) {
            return address;
        }
        return address.substring(0, 10) + "...";
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        Order order1 = new Order("ORD001", "John Doe", "123 Main Street, City, State 12345");
        
        VegItem salad = new VegItem("Garden Salad", 8.99, 2, true, "10 mins");
        VegItem pasta = new VegItem("Veg Pasta", 12.99, 1, false, "15 mins");
        
        NonVegItem chicken = new NonVegItem("Grilled Chicken", 15.99, 2, "Chicken", true);
        NonVegItem fishCurry = new NonVegItem("Fish Curry", 18.99, 1, "Fish", false);
        
        order1.addItem(salad);
        order1.addItem(pasta);
        order1.addItem(chicken);
        order1.addItem(fishCurry);
        
        order1.displayOrderDetails();
        
        System.out.println("\n\n=== Second Order ===");
        
        Order order2 = new Order("ORD002", "Jane Smith", "456 Oak Avenue, Town, Province 67890");
        
        VegItem soup = new VegItem("Tomato Soup", 6.99, 2, false, "8 mins");
        VegItem burger = new VegItem("Veg Burger", 9.99, 3, true, "12 mins");
        
        order2.addItem(soup);
        order2.addItem(burger);
        
        order2.displayOrderDetails();
        
        System.out.println("\n\n=== Food Delivery System Summary ===");
        System.out.println("Total Orders Processed: 2");
        System.out.println("Order 1 Total: $" + String.format("%.2f", order1.calculateOrderTotal()));
        System.out.println("Order 2 Total: $" + String.format("%.2f", order2.calculateOrderTotal()));
        System.out.println("Total Revenue: $" + String.format("%.2f", 
            order1.calculateOrderTotal() + order2.calculateOrderTotal()));
    }
}