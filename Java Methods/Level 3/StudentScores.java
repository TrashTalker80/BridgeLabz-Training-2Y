import java.util.Scanner;

public class StudentScores {

    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10; // Physics
            scores[i][1] = (int) (Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int) (Math.random() * 90) + 10; // Math
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            stats[i][0] = scores[i][0] + scores[i][1] + scores[i][2]; // Total
            stats[i][1] = Math.round((stats[i][0] / 3.0) * 100.0) / 100.0; // Average
            stats[i][2] = Math.round(((stats[i][0] / 300.0) * 100.0) * 100.0) / 100.0; // Percentage
        }
        return stats;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%.2f\t%.2f\t\t%.2f%%%n", (i + 1), scores[i][0], scores[i][1], scores[i][2], stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[][] scores = generateScores(numberOfStudents);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);

        scanner.close();
    }
}

