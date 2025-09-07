import java.util.Scanner;

public class RecursiveSum {

    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + recursiveSum(n - 1);
        }
    }

    public static int formulaSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n > 0) {
            int recursiveResult = recursiveSum(n);
            int formulaResult = formulaSum(n);

            System.out.println("The sum of the first " + n + " natural numbers using recursion is: " + recursiveResult);
            System.out.println("The sum of the first " + n + " natural numbers using the formula is: " + formulaResult);

            if (recursiveResult == formulaResult) {
                System.out.println("The results from both computations are correct.");
            } else {
                System.out.println("The results from the computations do not match.");
            }
        } else {
            System.out.println("Please enter a natural number.");
        }

        scanner.close();
    }
}

