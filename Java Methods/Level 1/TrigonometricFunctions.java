import java.util.Scanner;

public class TrigonometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println("The sine of the angle is: " + result[0]);
        System.out.println("The cosine of the angle is: " + result[1]);
        System.out.println("The tangent of the angle is: " + result[2]);

        scanner.close();
    }
}

