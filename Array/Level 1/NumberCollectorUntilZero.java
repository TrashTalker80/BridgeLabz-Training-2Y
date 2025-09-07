import java.util.Scanner;

class NumberCollectorUntilZero {
    
    public static double calculateSum(double[] numbers, int count) {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += numbers[i];
        }
        return total;
    }
    
    public static void displayNumbers(double[] numbers, int count) {
        System.out.println("Numbers entered:");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter up to 10 numbers (0 or negative to stop):");
        
        while (true) {
            System.out.print("Enter number: ");
            double number = input.nextDouble();
            
            if (number <= 0) {
                break;
            }
            
            if (index >= 10) {
                break;
            }
            
            numbers[index] = number;
            index++;
        }
        
        displayNumbers(numbers, index);
        total = calculateSum(numbers, index);
        System.out.println("Sum of all numbers: " + total);
        
        input.close();
    }
}
