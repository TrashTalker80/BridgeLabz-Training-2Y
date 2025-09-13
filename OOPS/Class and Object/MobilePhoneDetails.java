public class MobilePhoneDetails {
    private String brand;
    private String model;
    private double price;

    public MobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}

class MainMobilePhoneDetails {
    public static void main(String[] args) {
        MobilePhoneDetails phone = new MobilePhoneDetails("Apple", "iPhone 14", 90000.0);
        phone.displayDetails();
    }
}