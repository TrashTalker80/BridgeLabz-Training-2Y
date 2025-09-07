import java.util.Scanner;

public class BMICalculator {

    public static double[][] calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInCm = data[i][1];
            double heightInM = heightInCm / 100;
            data[i][2] = weight / (heightInM * heightInM);
        }
        return data;
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal";
            } else if (bmi >= 25 && bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }

        data = calculateBMI(data);
        String[] status = getBMIStatus(data);

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + data[i][1] + " cm, Weight=" + data[i][0] + " kg, BMI=" + data[i][2] + ", Status=" + status[i]);
        }

        scanner.close();
    }
}

