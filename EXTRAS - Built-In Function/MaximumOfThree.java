import java.util.Scanner;

class MaximumOfThree {
    public static void main(String[] args) {
        int[] numbers = getThreeNumbers();
        int maximum = findMaximum(numbers[0], numbers[1], numbers[2]);
        displayResult(maximum);
    }
    
    private static int[] getThreeNumbers() {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[3];
        
        numbers[0] = input.nextInt();
        numbers[1] = input.nextInt();
        numbers[2] = input.nextInt();
        
        input.close();
        return numbers;
    }
    
    private static int findMaximum(int num1, int num2, int num3) {
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }
        return max;
    }
    
    private static void displayResult(int maximum) {
        System.out.println("Maximum number is: " + maximum);
    }
}