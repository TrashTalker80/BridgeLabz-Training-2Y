import java.util.Scanner;

class ReverseDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }
        
        int[] digits = new int[10];
        int count = 0;
        
        while (number > 0 && count < 10) {
            digits[count] = number % 10;
            number /= 10;
            count++;
        }
        
        System.out.print("Reversed number: ");
        if (isNegative) {
            System.out.print("-");
        }
        
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
        
        input.close();
    }
}
