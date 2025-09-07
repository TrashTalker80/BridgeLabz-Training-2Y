import java.util.Scanner;

public class SubstringCreator {

    public String createSubstring(String text, int startIndex, int endIndex) {
        String sub = "";
        for (int i = startIndex; i < endIndex; i++) {
            sub += text.charAt(i);
        }
        return sub;
    }

    public boolean areStringsEqual(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.next();

        System.out.print("Enter the start index: ");
        int startIndex = scanner.nextInt();

        System.out.print("Enter the end index: ");
        int endIndex = scanner.nextInt();

        SubstringCreator creator = new SubstringCreator();
        String customSubstring = creator.createSubstring(text, startIndex, endIndex);
        System.out.println("Custom substring: " + customSubstring);

        String builtinSubstring = text.substring(startIndex, endIndex);
        System.out.println("Built-in substring: " + builtinSubstring);

        boolean areEqual = creator.areStringsEqual(customSubstring, builtinSubstring);
        System.out.println("Are the two substrings equal? " + areEqual);

        scanner.close();
    }
}