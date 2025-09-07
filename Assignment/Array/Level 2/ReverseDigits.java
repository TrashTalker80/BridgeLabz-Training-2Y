import java.util.Scanner;

class ReverseDigits {
    
    public static int countDigits(int number) {
        if (number == 0) return 1;
        
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    
    public static int[] extractDigits(int number, int digitCount) {
        int[] digits = new int[digitCount];
        
        if (number == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < digitCount; i++) {
                digits[i] = number % 10;
                number /= 10;
            }
        }
        
        return digits;
    }
    
    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversedDigits = new int[digits.length];
        
        for (int i = 0; i < digits.length; i++) {
            reversedDigits[i] = digits[digits.length - 1 - i];
        }
        
        return reversedDigits;
    }
    
    public static void displayReversedNumber(int[] reversedDigits) {
        System.out.print("Reversed number: ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        if (number < 0) {
            number = Math.abs(number);
            System.out.println("Working with absolute value: " + number);
        }
        
        int digitCount = countDigits(number);
        int[] digits = extractDigits(number, digitCount);
        
        System.out.print("Original digits: ");
        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
        
        int[] reversedDigits = reverseDigitsArray(digits);
        displayReversedNumber(reversedDigits);
        
        input.close();
    }
}
