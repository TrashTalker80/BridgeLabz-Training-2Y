import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int quotient = numberOfChocolates / numberOfChildren;
        int remainder = numberOfChocolates % numberOfChildren;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Each child will get " + result[0] + " chocolates.");
        System.out.println("The remaining chocolates are: " + result[1]);

        scanner.close();
    }
}

