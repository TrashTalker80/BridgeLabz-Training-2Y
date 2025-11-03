import java.util.Scanner;

public class LoginValidator {
    public static boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        String ageInput = scanner.nextLine();
        
        if (isValidAge(ageInput)) {
            System.out.println("Valid age. You can proceed with signup.");
        } else {
            System.out.println("Invalid age. You must be 18 or older.");
        }
        
        scanner.close();
    }
}
