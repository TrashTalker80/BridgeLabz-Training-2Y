import java.util.Scanner;

class FactorialRecursive {
    public static void main(String[] args) {
        int number = getInput();
        long factorial = calculateFactorial(number);
        displayOutput(number, factorial);
    }
    
    private static int getInput() {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.close();
        return number;
    }
    
    private static long calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
    
    private static void displayOutput(int number, long factorial) {
        System.out.println("Factorial of " + number + " is " + factorial);
    }
}