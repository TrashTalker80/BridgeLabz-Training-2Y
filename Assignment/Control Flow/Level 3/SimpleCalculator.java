import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double first = input.nextDouble();

        System.out.print("Enter the second number: ");
        double second = input.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        String op = input.next();

        double result;

        switch (op) {
            case "+":
                result = first + second;
                System.out.printf("%.2f + %.2f = %.2f\n", first, second, result);
                break;
            case "-":
                result = first - second;
                System.out.printf("%.2f - %.2f = %.2f\n", first, second, result);
                break;
            case "*":
                result = first * second;
                System.out.printf("%.2f * %.2f = %.2f\n", first, second, result);
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.printf("%.2f / %.2f = %.2f\n", first, second, result);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
        }
        input.close();
    }
}