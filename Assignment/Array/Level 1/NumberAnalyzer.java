import java.util.Scanner;

class NumberAnalyzer {
    
    public static void analyzeNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative.");
            } else {
                System.out.println(numbers[i] + " is zero.");
            }
        }
    }
    
    public static void compareFirstAndLast(int[] numbers) {
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        
        if (first == last) {
            System.out.println("First and last elements are equal: " + first);
        } else if (first > last) {
            System.out.println("First element " + first + " is greater than last element " + last);
        } else {
            System.out.println("First element " + first + " is less than last element " + last);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        
        analyzeNumbers(numbers);
        compareFirstAndLast(numbers);
        input.close();
    }
}
