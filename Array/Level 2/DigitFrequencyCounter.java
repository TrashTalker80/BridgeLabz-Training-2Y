import java.util.Scanner;

class DigitFrequencyCounter {
    
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
    
    public static int[] calculateFrequency(int[] digits) {
        int[] frequency = new int[10];
        
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }
        
        return frequency;
    }
    
    public static void displayFrequency(int[] frequency, int originalNumber) {
        System.out.println("\n=== DIGIT FREQUENCY ANALYSIS ===");
        System.out.println("Number: " + originalNumber);
        System.out.println("Digit frequencies:");
        
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        if (number < 0) {
            number = Math.abs(number);
            System.out.println("Working with absolute value: " + number);
        }
        
        int originalNumber = number;
        int digitCount = countDigits(number);
        int[] digits = extractDigits(number, digitCount);
        int[] frequency = calculateFrequency(digits);
        
        displayFrequency(frequency, originalNumber);
        
        input.close();
    }
}
