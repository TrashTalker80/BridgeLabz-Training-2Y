import java.util.Scanner;

public class StringLengthFinder {

    public static int findStringLength(String str) {
        int count = 0;
        try {
            for (int i = 0; true; i++) {
                str.charAt(i);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception is expected when we go past the end of the string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.next();

        int customLength = findStringLength(userInput);
        int builtInLength = userInput.length();

        System.out.println("Length from user-defined method: " + customLength);
        System.out.println("Length from built-in length() method: " + builtInLength);
        
        scanner.close();
    }
}