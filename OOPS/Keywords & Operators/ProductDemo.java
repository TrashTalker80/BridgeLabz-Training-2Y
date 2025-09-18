public class ProductDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "PROD001", 45000.0, 2);
        Product product2 = new Product("Mobile Phone", "PROD002", 25000.0, 5);
        Product product3 = new Product("Headphones", "PROD003", 2000.0, 10);
        
        System.out.println("Initial Discount: " + Product.getDiscount() + "%");
        System.out.println();
        
        product1.displayProductDetails();
        System.out.println("Price after discount: Rs. " + product1.getPriceAfterDiscount());
        System.out.println();
        
        product2.displayProductDetails();
        System.out.println("Price after discount: Rs. " + product2.getPriceAfterDiscount());
        System.out.println();
        
        Product.updateDiscount(15.0);
        System.out.println("Updated Discount: " + Product.getDiscount() + "%");
        System.out.println();
        
        product3.displayProductDetails();
        System.out.println("Price after discount: Rs. " + product3.getPriceAfterDiscount());
        System.out.println();
        
        System.out.println("Total Products in Cart: " + Product.getTotalProducts());
        
        System.out.println("\nInstance Check:");
        if (product1 instanceof Product) {
            System.out.println("product1 is an instance of Product class");
            System.out.println("Product ID: " + product1.getProductID());
        }
        
        Object obj = product2;
        if (obj instanceof Product) {
            System.out.println("obj (product2) is an instance of Product class");
            Product prodObj = (Product) obj;
            System.out.println("Product Name: " + prodObj.getProductName());
            System.out.println("Total Value: Rs. " + prodObj.getTotalValue());
        }
        
        if (product3 instanceof Product) {
            System.out.println("product3 is confirmed as Product instance");
        }
    }
}

class Product {
    private static double discount = 10.0;
    private static int totalProducts = 0;
    
    private String productName;
    private final String productID;
    private double price;
    private int quantity;
    
    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }
    
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    
    public static double getDiscount() {
        return discount;
    }
    
    public static int getTotalProducts() {
        return totalProducts;
    }
    
    public void displayProductDetails() {
        System.out.println("Product Name: " + this.productName);
        System.out.println("Product ID: " + this.productID);
        System.out.println("Price: Rs. " + this.price);
        System.out.println("Quantity: " + this.quantity);
    }
    
    public double getPriceAfterDiscount() {
        return this.price * (1 - discount / 100);
    }
    
    public double getTotalValue() {
        return this.price * this.quantity;
    }
    
    public String getProductID() {
        return productID;
    }
    
    public String getProductName() {
        return this.productName;
    }
}