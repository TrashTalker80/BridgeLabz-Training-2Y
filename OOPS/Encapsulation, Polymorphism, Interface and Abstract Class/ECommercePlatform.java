import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;
    
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public abstract double calculateDiscount();
    
    public double calculateFinalPrice() {
        double discount = calculateDiscount();
        double basePrice = price - discount;
        
        if (this instanceof Taxable) {
            Taxable taxableProduct = (Taxable) this;
            return basePrice + taxableProduct.calculateTax();
        }
        
        return basePrice;
    }
    
    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: $" + String.format("%.2f", price));
        System.out.println("Discount: $" + String.format("%.2f", calculateDiscount()));
        
        if (this instanceof Taxable) {
            Taxable taxableProduct = (Taxable) this;
            System.out.println("Tax: $" + String.format("%.2f", taxableProduct.calculateTax()));
            System.out.println(taxableProduct.getTaxDetails());
        }
        
        System.out.println("Final Price: $" + String.format("%.2f", calculateFinalPrice()));
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }
}

class Electronics extends Product implements Taxable {
    private double warrantyPeriod;
    private static final double ELECTRONICS_TAX_RATE = 0.18;
    private static final double DISCOUNT_RATE = 0.15;
    
    public Electronics(String productId, String name, double price, double warrantyPeriod) {
        super(productId, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }
    
    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * ELECTRONICS_TAX_RATE;
    }
    
    @Override
    public String getTaxDetails() {
        return "Electronics Tax Rate: " + (ELECTRONICS_TAX_RATE * 100) + "%, Warranty: " + warrantyPeriod + " years";
    }
    
    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }
    
    public void setWarrantyPeriod(double warrantyPeriod) {
        if (warrantyPeriod >= 0) {
            this.warrantyPeriod = warrantyPeriod;
        }
    }
}

class Clothing extends Product implements Taxable {
    private String size;
    private String material;
    private static final double CLOTHING_TAX_RATE = 0.12;
    private static final double DISCOUNT_RATE = 0.20;
    
    public Clothing(String productId, String name, double price, String size, String material) {
        super(productId, name, price);
        this.size = size;
        this.material = material;
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }
    
    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * CLOTHING_TAX_RATE;
    }
    
    @Override
    public String getTaxDetails() {
        return "Clothing Tax Rate: " + (CLOTHING_TAX_RATE * 100) + "%, Size: " + size + ", Material: " + material;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
}

class Groceries extends Product {
    private String expiryDate;
    private boolean isOrganic;
    private static final double DISCOUNT_RATE = 0.05;
    
    public Groceries(String productId, String name, double price, String expiryDate, boolean isOrganic) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
        this.isOrganic = isOrganic;
    }
    
    @Override
    public double calculateDiscount() {
        double discount = getPrice() * DISCOUNT_RATE;
        if (isOrganic) {
            discount += getPrice() * 0.02;
        }
        return discount;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public boolean isOrganic() {
        return isOrganic;
    }
    
    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics laptop = new Electronics("ELEC001", "Gaming Laptop", 1500.00, 2.0);
        Electronics smartphone = new Electronics("ELEC002", "Smartphone Pro", 999.00, 1.5);
        
        Clothing shirt = new Clothing("CLOTH001", "Cotton Shirt", 49.99, "L", "Cotton");
        Clothing jeans = new Clothing("CLOTH002", "Denim Jeans", 79.99, "32", "Denim");
        
        Groceries apples = new Groceries("GROC001", "Organic Apples", 5.99, "2024-02-01", true);
        Groceries bread = new Groceries("GROC002", "Whole Wheat Bread", 3.49, "2024-01-25", false);
        
        products.add(laptop);
        products.add(smartphone);
        products.add(shirt);
        products.add(jeans);
        products.add(apples);
        products.add(bread);
        
        System.out.println("=== E-Commerce Platform ===\n");
        
        double totalRevenue = 0;
        double totalTax = 0;
        double totalDiscount = 0;
        
        for (Product product : products) {
            product.displayProductInfo();
            System.out.println("-------------------");
            
            totalRevenue += product.calculateFinalPrice();
            totalDiscount += product.calculateDiscount();
            
            if (product instanceof Taxable) {
                totalTax += ((Taxable) product).calculateTax();
            }
        }
        
        System.out.println("\n=== Sales Summary ===");
        System.out.println("Total Products: " + products.size());
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        System.out.println("Total Tax Collected: $" + String.format("%.2f", totalTax));
        System.out.println("Total Discounts Given: $" + String.format("%.2f", totalDiscount));
    }
}