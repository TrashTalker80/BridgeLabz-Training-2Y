import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown start number: ");
        int start = input.nextInt();

        for (int counter = start; counter >= 1; counter--) {
            System.out.println(counter);
        }
        System.out.println("Blast off!");
        input.close();
    }
}