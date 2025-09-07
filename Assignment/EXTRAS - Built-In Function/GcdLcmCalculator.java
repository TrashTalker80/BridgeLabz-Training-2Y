import java.util.Scanner;

class GcdLcmCalculator {
    public static void main(String[] args) {
        int[] numbers = getTwoNumbers();
        int gcd = calculateGcd(numbers[0], numbers[1]);
        int lcm = calculateLcm(numbers[0], numbers[1], gcd);
        displayResults(numbers[0], numbers[1], gcd, lcm);
    }
    
    private static int[] getTwoNumbers() {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[2];
        numbers[0] = input.nextInt();
        numbers[1] = input.nextInt();
        input.close();
        return numbers;
    }
    
    private static int calculateGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static int calculateLcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    
    private static void displayResults(int num1, int num2, int gcd, int lcm) {
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}