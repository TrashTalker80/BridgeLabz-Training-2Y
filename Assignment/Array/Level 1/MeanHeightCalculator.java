import java.util.Scanner;

class MeanHeightCalculator {
    
    public static double calculateSum(double[] heights) {
        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        return sum;
    }
    
    public static double calculateMean(double[] heights) {
        double sum = calculateSum(heights);
        return sum / heights.length;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        
        System.out.println("Enter heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = input.nextDouble();
        }
        
        double meanHeight = calculateMean(heights);
        System.out.println("Mean height of the football team: " + meanHeight);
        
        input.close();
    }
}
