import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter weight (in kg): ");
        double weight = input.nextDouble();
        
        System.out.print("Enter height (in cm): ");
        double heightCm = input.nextDouble();
        
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);
        
        String status;
        
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        System.out.println("\nBMI Results:");
        System.out.println("BMI: " + String.format("%.2f", bmi));
        System.out.println("Status: " + status);
        
        input.close();
    }
}
