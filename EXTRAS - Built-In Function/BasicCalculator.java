import java.util.Scanner;

class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter first number:");
        double num1 = input.nextDouble();
        
        System.out.println("Enter second number:");
        double num2 = input.nextDouble();
        
        System.out.println("Enter operation (+, -, *, /):");
        char operation = input.next().charAt(0);
        
        double result = performOperation(num1, num2, operation);
        System.out.println("Result: " + result);
        
        input.close();
    }
    
    private static double performOperation(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return add(num1, num2);
            case '-':
                return subtract(num1, num2);
            case '*':
                return multiply(num1, num2);
            case '/':
                return divide(num1, num2);
            default:
                return 0;
        }
    }
    
    private static double add(double a, double b) {
        return a + b;
    }
    
    private static double subtract(double a, double b) {
        return a - b;
    }
    
    private static double multiply(double a, double b) {
        return a * b;
    }
    
    private static double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        return 0;
    }
}