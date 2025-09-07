import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = input.nextInt();
        
        int[] results = new int[10];
        
        for (int i = 0; i < results.length; i++) {
            results[i] = number * (i + 1);
        }
        
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < results.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + results[i]);
        }
        
        input.close();
    }
}
