import java.util.Scanner;

class MultiplicationTableSixToNine {
    
    public static int[] generateMultiplicationTableSixToNine(int number) {
        int[] multiplicationResult = new int[4];
        for (int i = 0; i < multiplicationResult.length; i++) {
            multiplicationResult[i] = number * (i + 6);
        }
        return multiplicationResult;
    }
    
    public static void displayMultiplicationTable(int number, int[] results) {
        System.out.println("Multiplication table for " + number + " from 6 to 9:");
        for (int i = 0; i < results.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + results[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int[] results = generateMultiplicationTableSixToNine(number);
        displayMultiplicationTable(number, results);
        
        input.close();
    }
}
