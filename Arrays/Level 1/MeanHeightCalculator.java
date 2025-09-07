import java.util.Scanner;

class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[] heights = new double[11];
        double sum = 0.0;
        
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = input.nextDouble();
            sum += heights[i];
        }
        
        double mean = sum / 11;
        
        System.out.println("\nMean height of the football team: " + mean);
        
        input.close();
    }
}
