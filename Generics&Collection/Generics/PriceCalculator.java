import java.util.Arrays;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Mobile extends Product {
    public Mobile(String name, double price) {
        super(name, price);
    }
}

class Laptop extends Product {
    public Laptop(String name, double price) {
        super(name, price);
    }
}

class Tablet extends Product {
    public Tablet(String name, double price) {
        super(name, price);
    }
}

public class PriceCalculator {
    public static double calculateTotal(List<? extends Product> items) {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = Arrays.asList(
            new Mobile("iPhone", 999.99),
            new Mobile("Samsung", 799.99)
        );
        System.out.println("Mobile total: $" + calculateTotal(mobiles));

        List<Laptop> laptops = Arrays.asList(
            new Laptop("MacBook", 1999.99),
            new Laptop("Dell", 1299.99)
        );
        System.out.println("Laptop total: $" + calculateTotal(laptops));

        List<Product> mixed = Arrays.asList(
            new Mobile("OnePlus", 599.99),
            new Laptop("HP", 899.99),
            new Tablet("iPad", 499.99)
        );
        System.out.println("Mixed total: $" + calculateTotal(mixed));
    }
}
