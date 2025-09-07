import java.util.Scanner;

class BMICalculator2D {
    
    public static void inputPersonData(double[][] personData, Scanner input) {
        for (int i = 0; i < personData.length; i++) {
            while (true) {
                System.out.print("Person " + (i + 1) + " weight (kg): ");
                double weight = input.nextDouble();
                System.out.print("Person " + (i + 1) + " height (m): ");
                double height = input.nextDouble();
                
                if (weight <= 0 || height <= 0) {
                    System.out.println("Please enter positive values for weight and height.");
                    continue;
                }
                
                personData[i][0] = weight;
                personData[i][1] = height;
                break;
            }
        }
    }
    
    public static void calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            personData[i][2] = weight / (height * height);
        }
    }
    
    public static void determineWeightStatus(double[][] personData, String[] weightStatus) {
        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25.0) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
    }
    
    public static void displayResults(double[][] personData, String[] weightStatus) {
        System.out.println("\n=== BMI CALCULATION RESULTS (2D Array) ===");
        System.out.printf("%-8s %-10s %-10s %-8s %-12s%n", "Person", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("--------------------------------------------------------");
        
        for (int i = 0; i < personData.length; i++) {
            System.out.printf("%-8d %-10.2f %-10.2f %-8.2f %-12s%n", 
                            (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numPersons = input.nextInt();
        
        double[][] personData = new double[numPersons][3];
        String[] weightStatus = new String[numPersons];
        
        inputPersonData(personData, input);
        calculateBMI(personData);
        determineWeightStatus(personData, weightStatus);
        displayResults(personData, weightStatus);
        
        input.close();
    }
}
