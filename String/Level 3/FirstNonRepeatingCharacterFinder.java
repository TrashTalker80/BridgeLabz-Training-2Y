import java.util.Scanner;

public class FirstNonRepeatingCharacterFinder {

    private static final int ASCII_CHARACTER_COUNT = 256;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        char firstNonRepeating = findFirstNonRepeating(text);

        if (firstNonRepeating != '\0') {
            System.out.println("The first non-repeating character is: '" + firstNonRepeating + "'");
        } else {
            System.out.println("There are no non-repeating characters in the string.");
        }
        scanner.close();
    }

    public static char findFirstNonRepeating(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }
        
        int[] charFrequencies = new int[ASCII_CHARACTER_COUNT];

        for (int i = 0; i < text.length(); i++) {
            charFrequencies[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (charFrequencies[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}