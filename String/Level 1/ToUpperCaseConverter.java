import java.util.Scanner;

public class ToUpperCaseConverter {

    public String convertToUpperCase(String text) {
        String upperCaseText = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                upperCaseText += (char) (ch - 32);
            } else {
                upperCaseText += ch;
            }
        }
        return upperCaseText;
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

        System.out.print("Enter the text to convert to uppercase: ");
        String text = scanner.nextLine();

        ToUpperCaseConverter converter = new ToUpperCaseConverter();
        String customUpperCase = converter.convertToUpperCase(text);
        System.out.println("Custom uppercase version: " + customUpperCase);

        String builtinUpperCase = text.toUpperCase();
        System.out.println("Built-in uppercase version: " + builtinUpperCase);

        boolean areEqual = converter.areStringsEqual(customUpperCase, builtinUpperCase);
        System.out.println("Are the two uppercase strings equal? " + areEqual);

        scanner.close();
    }
}