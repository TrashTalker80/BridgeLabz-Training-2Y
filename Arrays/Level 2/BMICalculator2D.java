import java.util.Scanner;

class BMICalculator2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();
        
        double[][] personData = new double[n][3];
        String[] names = new String[n];
        String[] weightStatus = new String[n];
        
        System.out.println("\nEnter details for " + n + " persons:");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            System.out.print("Name: ");
            names[i] = input.next();
            
            System.out.print("Weight (kg): ");
            personData[i][0] = input.nextDouble();
            while (personData[i][0] <= 0) {
                System.out.print("Weight must be positive. Enter again: ");
                personData[i][0] = input.nextDouble();
            }
            
            System.out.print("Height (m): ");
            personData[i][1] = input.nextDouble();
            while (personData[i][1] <= 0) {
                System.out.print("Height must be positive. Enter again: ");
                personData[i][1] = input.nextDouble();
            }
            
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }
        
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-15s %-10s %-10s %-10s %-15s\n", "Name", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f %-15s\n", 
                names[i], personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        
        input.close();
    }
}
