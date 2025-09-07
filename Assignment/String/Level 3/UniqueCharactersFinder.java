import java.util.Scanner;
import java.util.Arrays;

public class UniqueCharactersFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.println("Unique characters in the string are: " + Arrays.toString(uniqueChars));
        System.out.println("Length of the text without using length() method is: " + getTextLength(text));
        
        scanner.close();
    }

    public static int getTextLength(String text) {
        int length = 0;
        try {
            for (length = 0; ; length++) {
                text.charAt(length);
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception indicates we've reached the end of the string.
        }
        return length;
    }

    public static char[] findUniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return new char[0];
        }

        char[] tempArray = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                tempArray[uniqueCount++] = currentChar;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        System.arraycopy(tempArray, 0, uniqueChars, 0, uniqueCount);
        return uniqueChars;
    }
}