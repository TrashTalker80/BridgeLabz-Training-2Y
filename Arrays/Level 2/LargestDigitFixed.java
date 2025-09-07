import java.util.Scanner;

class LargestDigitFixed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        if (number < 0) {
            number = -number;
        }
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        while (number > 0 && index < maxDigit) {
            digits[index] = number % 10;
            number /= 10;
            index++;
        }
        
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] < largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        input.close();
    }
}
