import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }

    public void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.err.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (at least 6 characters long): ");
        String userInput = scanner.nextLine();
        
        IllegalArgumentExceptionDemo demo = new IllegalArgumentExceptionDemo();

        System.out.println("\n--- Demonstrating handling the exception ---");
        demo.handleException(userInput);

        System.out.println("\n--- Demonstrating generating the unhandled exception ---");
        try {
            demo.generateException(userInput);
        } catch(IllegalArgumentException e) {
            System.err.println("Exception was generated and caught in main: " + e.getMessage());
        }

        scanner.close();
    }
}