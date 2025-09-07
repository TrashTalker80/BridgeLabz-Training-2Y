import java.util.Scanner;

class FizzBuzzArray {
    
    public static String[] generateFizzBuzz(int number) {
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            System.exit(0);
        }
        
        String[] results = new String[number + 1];
        
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0 && i != 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0 && i != 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }
        
        return results;
    }
    
    public static void displayFizzBuzzResults(String[] results) {
        for (int i = 1; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        String[] fizzBuzzResults = generateFizzBuzz(number);
        displayFizzBuzzResults(fizzBuzzResults);
        
        input.close();
    }
}
