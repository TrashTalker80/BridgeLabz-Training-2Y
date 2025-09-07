import java.util.Scanner;

class PalindromeChecker {
    public static void main(String[] args) {
        String input = getInput();
        boolean isPalindrome = checkPalindrome(input);
        displayResult(input, isPalindrome);
    }
    
    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
    
    private static boolean checkPalindrome(String str) {
        String cleanStr = str.toLowerCase().replaceAll("[^a-z]", "");
        int length = cleanStr.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (cleanStr.charAt(i) != cleanStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    private static void displayResult(String input, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("'" + input + "' is a palindrome");
        } else {
            System.out.println("'" + input + "' is not a palindrome");
        }
    }
}