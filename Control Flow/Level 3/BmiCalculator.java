import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight in kg: ");
        double weight = input.nextDouble();
        System.out.print("Enter your height in cm: ");
        double heightInCm = input.nextDouble();

        double heightInM = heightInCm / 100.0;
        double bmi = weight / (heightInM * heightInM);

        System.out.printf("Your BMI is: %.2f\n", bmi);

        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }
        input.close();
    }
}