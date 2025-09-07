import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();
        
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] names = new String[n];
        String[] status = new String[n];
        
        System.out.println("\nEnter details for " + n + " persons:");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            System.out.print("Name: ");
            names[i] = input.next();
            
            System.out.print("Weight (kg): ");
            weight[i] = input.nextDouble();
            while (weight[i] <= 0) {
                System.out.print("Weight must be positive. Enter again: ");
                weight[i] = input.nextDouble();
            }
            
            System.out.print("Height (m): ");
            height[i] = input.nextDouble();
            while (height[i] <= 0) {
                System.out.print("Height must be positive. Enter again: ");
                height[i] = input.nextDouble();
            }
            
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obesity";
            }
        }
        
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-15s %-10s %-10s %-10s %-15s\n", "Name", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");
        
        int underweight = 0, normal = 0, overweight = 0, obese = 0;
        String unhealthiest = "";
        double maxDeviation = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f %-15s\n", 
                names[i], weight[i], height[i], bmi[i], status[i]);
            
            if (status[i].equals("Underweight")) {
                underweight++;
            } else if (status[i].equals("Normal weight")) {
                normal++;
            } else if (status[i].equals("Overweight")) {
                overweight++;
            } else {
                obese++;
            }
            
            double deviation = Math.abs(bmi[i] - 22.0);
            if (deviation > maxDeviation) {
                maxDeviation = deviation;
                unhealthiest = names[i];
            }
        }
        
        System.out.println("\n--- Summary ---");
        System.out.println("Underweight: " + underweight);
        System.out.println("Normal weight: " + normal);
        System.out.println("Overweight: " + overweight);
        System.out.println("Obese: " + obese);
        System.out.println("\nMost unhealthy person (farthest from ideal BMI 22): " + unhealthiest);
        
        input.close();
    }
}
