import java.util.Scanner;

class OddEvenSeparator {
    
    public static void separateOddEven(int number) {
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number (positive integer).");
            System.exit(0);
        }
        
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0;
        int oddIndex = 0;
        
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }
        
        displayEvenNumbers(evenNumbers, evenIndex);
        displayOddNumbers(oddNumbers, oddIndex);
    }
    
    public static void displayEvenNumbers(int[] evenNumbers, int count) {
        System.out.print("Even numbers: ");
        for (int i = 0; i < count; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
    }
    
    public static void displayOddNumbers(int[] oddNumbers, int count) {
        System.out.print("Odd numbers: ");
        for (int i = 0; i < count; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        separateOddEven(number);
        
        input.close();
    }
}
