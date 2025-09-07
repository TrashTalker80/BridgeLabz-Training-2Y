import java.util.Arrays;
import java.util.Scanner;

public class StringSplitter {

    public static String[] splitString(String text) {
        int wordCount = 0;
        if (text.length() > 0) {
            wordCount = 1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    wordCount++;
                }
            }
        }

        String[] words = new String[wordCount];
        String currentWord = "";
        int wordIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex] = currentWord;
                currentWord = "";
                wordIndex++;
            } else {
                currentWord += text.charAt(i);
            }
        }
        words[wordIndex] = currentWord;
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        String[] customSplit = splitString(userInput);
        String[] builtInSplit = userInput.split(" ");

        System.out.println("Custom split result: " + Arrays.toString(customSplit));
        System.out.println("Built-in split() result: " + Arrays.toString(builtInSplit));

        boolean areEqual = compareStringArrays(customSplit, builtInSplit);
        System.out.println("Are the two split arrays equal? " + areEqual);
        
        scanner.close();
    }
}