import java.util.Scanner;

class BMICalculator {
    
    public static void inputPersonData(double[] weights, double[] heights, Scanner input) {
        for (int i = 0; i < weights.length; i++) {
            while (true) {
                System.out.print("Person " + (i + 1) + " weight (kg): ");
                double weight = input.nextDouble();
                System.out.print("Person " + (i + 1) + " height (m): ");
                double height = input.nextDouble();
                
                if (weight <= 0 || height <= 0) {
                    System.out.println("Please enter positive values for weight and height.");
                    continue;
                }
                
                weights[i] = weight;
                heights[i] = height;
                break;
            }
        }
    }
    
    public static void calculateBMI(double[] weights, double[] heights, double[] bmi) {
        for (int i = 0; i < weights.length; i++) {
            bmi[i] = weights[i] / (heights[i] * heights[i]);
        }
    }
    
    public static void determineWeightStatus(double[] bmi, String[] weightStatus) {
        for (int i = 0; i < bmi.length; i++) {
            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] < 25.0) {
                weightStatus[i] = "Normal";
            } else if (bmi[i] < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
    }
    
    public static void displayResults(double[] weights, double[] heights, double[] bmi, String[] weightStatus) {
        System.out.println("\n=== BMI CALCULATION RESULTS ===");
        System.out.printf("%-8s %-10s %-10s %-8s %-12s%n", "Person", "Weight(kg)", "Height(m)", "BMI", "Status");
        System.out.println("--------------------------------------------------------");
        
        for (int i = 0; i < weights.length; i++) {
            System.out.printf("%-8d %-10.2f %-10.2f %-8.2f %-12s%n", 
                            (i + 1), weights[i], heights[i], bmi[i], weightStatus[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numPersons = input.nextInt();
        
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmi = new double[numPersons];
        String[] weightStatus = new String[numPersons];
        
        inputPersonData(weights, heights, input);
        calculateBMI(weights, heights, bmi);
        determineWeightStatus(bmi, weightStatus);
        displayResults(weights, heights, bmi, weightStatus);
        
        input.close();
    }
}
