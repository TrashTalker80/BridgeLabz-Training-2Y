import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    public void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        StringIndexOutOfBoundsDemo demo = new StringIndexOutOfBoundsDemo();

        System.out.println("\n--- Demonstrating handling the exception ---");
        demo.handleException(userInput);

        System.out.println("\n--- Demonstrating generating the unhandled exception ---");
        try {
            demo.generateException(userInput);
        } catch(StringIndexOutOfBoundsException e) {
            System.err.println("Exception was generated and caught in main: " + e.getMessage());
        }
        
        scanner.close();
    }
}