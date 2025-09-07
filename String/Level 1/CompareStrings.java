import java.util.Scanner;

public class CompareStrings {

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

        System.out.print("Enter the first string: ");
        String firstString = scanner.next();

        System.out.print("Enter the second string: ");
        String secondString = scanner.next();

        CompareStrings comparator = new CompareStrings();
        boolean customResult = comparator.areStringsEqual(firstString, secondString);
        System.out.println("Result from custom comparison: " + customResult);

        boolean builtinResult = firstString.equals(secondString);
        System.out.println("Result from built-in equals(): " + builtinResult);

        if (customResult == builtinResult) {
            System.out.println("Both methods produce the same result.");
        } else {
            System.out.println("The results from the two methods are different.");
        }
        scanner.close();
    }
}