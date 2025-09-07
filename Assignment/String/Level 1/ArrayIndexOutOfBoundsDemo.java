import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public void generateException(String[] names) {
        System.out.println("Accessing element at index " + names.length + ": " + names[names.length]);
    }

    public void handleException(String[] names) {
        try {
            System.out.println("Accessing element at index " + names.length + ": " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many names do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        String[] namesArray = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            namesArray[i] = scanner.nextLine();
        }

        ArrayIndexOutOfBoundsDemo demo = new ArrayIndexOutOfBoundsDemo();
        
        System.out.println("\n--- Demonstrating handling the exception ---");
        demo.handleException(namesArray);
        
        System.out.println("\n--- Demonstrating generating the unhandled exception ---");
        try {
            demo.generateException(namesArray);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("Exception was generated and caught in main: " + e.getMessage());
        }
        
        scanner.close();
    }
}