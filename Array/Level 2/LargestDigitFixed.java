import java.util.Scanner;

class LargestDigitFixed {
    
    public static int[] extractDigits(int number) {
        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;
        
        if (number == 0) {
            digits[0] = 0;
            index = 1;
        } else {
            while (number != 0 && index < maxDigits) {
                digits[index] = number % 10;
                number /= 10;
                index++;
            }
            
            if (number != 0) {
                System.out.println("Warning: Number has more than 10 digits. Only first 10 digits considered.");
            }
        }
        
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = digits[i];
        }
        
        return result;
    }
    
    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("Largest digit: " + largest);
        if (secondLargest == 0 && largest != 0) {
            System.out.println("Second largest digit: Not found (all digits are the same)");
        } else {
            System.out.println("Second largest digit: " + secondLargest);
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
        
        int[] digits = extractDigits(number);
        findLargestAndSecondLargest(digits);
        
        input.close();
    }
}
