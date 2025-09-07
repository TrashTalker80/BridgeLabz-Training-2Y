import java.util.Scanner;

class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        if (number <= 0) {
            System.err.println("Error: Please enter a positive integer");
            System.exit(0);
        }
        
        String[] results = new String[number + 1];
        
        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                results[i] = String.valueOf(i);
            } else if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }
        
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
        
        input.close();
    }
}
