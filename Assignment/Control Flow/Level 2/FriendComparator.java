import java.util.Scanner;

public class FriendComparator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Amar's age and height:");
        int amarAge = input.nextInt();
        double amarHeight = input.nextDouble();

        System.out.println("Enter Akbar's age and height:");
        int akbarAge = input.nextInt();
        double akbarHeight = input.nextDouble();

        System.out.println("Enter Anthony's age and height:");
        int anthonyAge = input.nextInt();
        double anthonyHeight = input.nextDouble();

        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Amar is the youngest.");
        } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }

        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the tallest.");
        } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }

        input.close();
    }
}