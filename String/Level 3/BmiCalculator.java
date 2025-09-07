import java.util.Scanner;

public class BmiCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][2];

        System.out.println("Enter the weight (kg) and height (cm) for 10 people:");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm): ");
            personData[i][1] = scanner.nextDouble();
        }

        String[][] bmiReport = processBmiData(personData);
        displayBmiReport(bmiReport);
        scanner.close();
    }

    public static String[][] processBmiData(double[][] personData) {
        String[][] report = new String[10][4];
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            String[] bmiDetails = getBmiAndStatus(weight, height);

            report[i][0] = String.valueOf(height);
            report[i][1] = String.valueOf(weight);
            report[i][2] = bmiDetails[0];
            report[i][3] = bmiDetails[1];
        }
        return report;
    }

    public static String[] getBmiAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    public static void displayBmiReport(String[][] report) {
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-15s | %-15s | %-10s | %-15s\n", "Height (cm)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");

        for (String[] personReport : report) {
            System.out.printf("%-15s | %-15s | %-10s | %-15s\n",
                    personReport[0], personReport[1], personReport[2], personReport[3]);
        }
        System.out.println("-------------------------------------------------------------");
    }
}