import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String text = scanner.nextLine();

        System.out.println("\n--- Checking with Logic 1 (Iterative) ---");
        if (isPalindromeLogic1(text)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        System.out.println("\n--- Checking with Logic 2 (Recursive) ---");
        if (isPalindromeLogic2(text)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        
        System.out.println("\n--- Checking with Logic 3 (Reverse and Compare) ---");
        if (isPalindromeLogic3(text)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        
        scanner.close();
    }

    public static boolean isPalindromeLogic1(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeLogic2(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }
    
    private static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    public static boolean isPalindromeLogic3(String text) {
        String reversedString = reverseString(text);
        return text.equals(reversedString);
    }

    private static String reverseString(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return reversed;
    }
}