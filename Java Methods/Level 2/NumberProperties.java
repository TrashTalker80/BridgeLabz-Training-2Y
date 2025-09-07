import java.util.Scanner;

public class NumberProperties {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.print("Number " + number + " is positive");
                if (isEven(number)) {
                    System.out.println(" and even.");
                } else {
                    System.out.println(" and odd.");
                }
            } else {
                System.out.println("Number " + number + " is negative.");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 1) {
            System.out.println("The first element is greater than the last element.");
        } else if (comparisonResult == -1) {
            System.out.println("The first element is less than the last element.");
        } else {
            System.out.println("The first and last elements are equal.");
        }

        scanner.close();
    }
}

