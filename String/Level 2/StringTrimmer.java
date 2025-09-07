import java.util.Scanner;

public class StringTrimmer {

    public static int[] customTrim(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String userInput = scanner.nextLine();

        int[] trimIndices = customTrim(userInput);
        String customTrimmed = createSubstring(userInput, trimIndices[0], trimIndices[1]);
        String builtInTrimmed = userInput.trim();

        System.out.println("Custom trimmed string: '" + customTrimmed + "'");
        System.out.println("Built-in trim() string: '" + builtInTrimmed + "'");

        boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Do the results match? " + areEqual);
        
        scanner.close();
    }
}