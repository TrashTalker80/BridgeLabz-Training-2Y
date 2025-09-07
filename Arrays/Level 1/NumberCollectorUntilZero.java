import java.util.Scanner;

class NumberCollectorUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter up to 10 numbers (enter 0 or negative to stop):");
        
        while (true) {
            System.out.print("Number " + (index + 1) + ": ");
            double number = input.nextDouble();
            
            if (number <= 0) {
                break;
            }
            
            numbers[index] = number;
            index++;
            
            if (index >= 10) {
                break;
            }
        }
        
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total += numbers[i];
        }
        
        System.out.println("\nSum of all numbers: " + total);
        
        input.close();
    }
}
