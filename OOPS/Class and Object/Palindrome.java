public class Palindrome {
    private String text;

    public Palindrome(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void displayResult() {
        if(isPalindrome()) {
            System.out.println(text + " is a palindrome");
        } else {
            System.out.println(text + " is not a palindrome");
        }
    }
}

class MainPalindrome {
    public static void main(String[] args) {
        Palindrome pc = new Palindrome("Racecar");
        pc.displayResult();
    }
}