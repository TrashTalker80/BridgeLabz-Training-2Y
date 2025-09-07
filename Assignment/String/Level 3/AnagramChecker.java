import java.util.Scanner;

public class AnagramChecker {

    private static final int ASCII_CHARACTER_COUNT = 256;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String text1 = scanner.nextLine().toLowerCase();
        System.out.print("Enter the second string: ");
        String text2 = scanner.nextLine().toLowerCase();

        if (areAnagrams(text1, text2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
        scanner.close();
    }

    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        int[] charFrequencies = new int[ASCII_CHARACTER_COUNT];
        
        for (int i = 0; i < text1.length(); i++) {
            charFrequencies[text1.charAt(i)]++;
            charFrequencies[text2.charAt(i)]--;
        }
        
        for (int i = 0; i < ASCII_CHARACTER_COUNT; i++) {
            if (charFrequencies[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}