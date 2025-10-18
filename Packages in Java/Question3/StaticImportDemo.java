import static java.lang.Math.*;

public class StaticImportDemo {
    public static void main(String[] args) {
        double number = 16.0;
        double base = 2.0;
        double exponent = 3.0;
        double a = -10.5;
        double b = 20.3;
        
        System.out.println("Square root of " + number + " is: " + sqrt(number));
        System.out.println(base + " raised to power " + exponent + " is: " + pow(base, exponent));
        System.out.println("Maximum of " + a + " and " + b + " is: " + max(a, b));
        System.out.println("Minimum of " + a + " and " + b + " is: " + min(a, b));
        System.out.println("Absolute value of " + a + " is: " + abs(a));
    }
}
