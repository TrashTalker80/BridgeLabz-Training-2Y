import java.util.Scanner;

public class PowerCalculatorFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base number: ");
        int number = input.nextInt();
        
        System.out.print("Enter power: ");
        int power = input.nextInt();
        
        if (number >= 0 && power >= 0) {
            long result = 1;
            
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            
            System.out.println(number + " raised to the power " + power + " is " + result);
        } else {
            System.out.println("Please enter positive integers");
        }
        
        input.close();
    }
}
