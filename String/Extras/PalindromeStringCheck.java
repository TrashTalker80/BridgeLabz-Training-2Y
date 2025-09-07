public class PalindromeStringCheck {

    public static boolean isPalindrome(String str) {
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        return str.equalsIgnoreCase(reversedStr);
    }

    public static void main(String[] args) {
        String input1 = "madam";
        String input2 = "hello";
        System.out.println("\"" + input1 + "\" is a palindrome: " + isPalindrome(input1));
        System.out.println("\"" + input2 + "\" is a palindrome: " + isPalindrome(input2));
    }
}