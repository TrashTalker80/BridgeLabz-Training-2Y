import java.util.Scanner;

class FactorsFinder {
    
    public static int[] findFactors(int number) {
        int maxFactors = 10;
        int[] factors = new int[maxFactors];
        int index = 0;
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactors) {
                    maxFactors = maxFactors * 2;
                    int[] temp = new int[maxFactors];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index] = i;
                index++;
            }
        }
        
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = factors[i];
        }
        
        return result;
    }
    
    public static void displayFactors(int number, int[] factors) {
        System.out.println("Factors of " + number + ":");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int[] factors = findFactors(number);
        displayFactors(number, factors);
        
        input.close();
    }
}
