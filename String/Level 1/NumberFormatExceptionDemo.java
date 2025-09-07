import java.util.Scanner;

public class NumberFormatExceptionDemo {

    public void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    public void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.err.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to convert to a number: ");
        String userInput = scanner.nextLine();
        
        NumberFormatExceptionDemo demo = new NumberFormatExceptionDemo();

        System.out.println("\n--- Demonstrating handling the exception ---");
        demo.handleException(userInput);
        
        System.out.println("\n--- Demonstrating generating the unhandled exception ---");
        try {
             demo.generateException(userInput);
        } catch(NumberFormatException e) {
            System.err.println("Exception was generated and caught in main: " + e.getMessage());
        }

        scanner.close();
    }
}