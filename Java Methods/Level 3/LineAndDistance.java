import java.util.Scanner;

public class LineAndDistance {

    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates of point A (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Enter the coordinates of point B (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("The Euclidean distance between the two points is: " + euclideanDistance(x1, y1, x2, y2));

        double[] equation = findLineEquation(x1, y1, x2, y2);
        System.out.println("The equation of the line is: y = " + equation[0] + "x + " + equation[1]);

        scanner.close();
    }
}

