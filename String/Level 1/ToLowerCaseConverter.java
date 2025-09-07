import java.util.Scanner;

public class ToLowerCaseConverter {

    public String convertToLowerCase(String text) {
        String lowerCaseText = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lowerCaseText += (char) (ch + 32);
            } else {
                lowerCaseText += ch;
            }
        }
        return lowerCaseText;
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

        System.out.print("Enter the text to convert to lowercase: ");
        String text = scanner.nextLine();

        ToLowerCaseConverter converter = new ToLowerCaseConverter();
        String customLowerCase = converter.convertToLowerCase(text);
        System.out.println("Custom lowercase version: " + customLowerCase);

        String builtinLowerCase = text.toLowerCase();
        System.out.println("Built-in lowercase version: " + builtinLowerCase);

        boolean areEqual = converter.areStringsEqual(customLowerCase, builtinLowerCase);
        System.out.println("Are the two lowercase strings equal? " + areEqual);
        
        scanner.close();
    }
}