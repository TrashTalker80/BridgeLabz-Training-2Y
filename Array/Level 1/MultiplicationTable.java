import java.util.Scanner;

class MultiplicationTable {
    
    public static int[] generateMultiplicationTable(int number) {
        int[] table = new int[10];
        for (int i = 0; i < table.length; i++) {
            table[i] = number * (i + 1);
        }
        return table;
    }
    
    public static void displayMultiplicationTable(int number, int[] table) {
        System.out.println("Multiplication table for " + number + ":");
        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int[] multiplicationTable = generateMultiplicationTable(number);
        displayMultiplicationTable(number, multiplicationTable);
        
        input.close();
    }
}
