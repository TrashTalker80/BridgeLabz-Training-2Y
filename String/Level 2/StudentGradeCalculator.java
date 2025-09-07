import java.util.Random;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = random.nextInt(100); // Physics
            scores[i][1] = random.nextInt(100); // Chemistry
            scores[i][2] = random.nextInt(100); // Math
        }
        return scores;
    }

    public static double[][] calculatePercentages(int[][] scores) {
        double[][] results = new double[scores.length][3]; // total, average, percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3.0;
            double percentage = (double) total / 300.0 * 100.0;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String[] assignGrades(double[][] percentages) {
        String[] grades = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            double p = percentages[i][2];
            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] calcs, String[] grades) {
        System.out.println("--- Student Scorecard ---");
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-12s | %-5s\n", 
            "Student", "Physics", "Chemistry", "Math", "Total", "Percentage %", "Grade");
        System.out.println("--------------------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s | %-10d | %-10d | %-10d | %-10.0f | %-12.2f | %-5s\n",
                "Student " + (i + 1), scores[i][0], scores[i][1], scores[i][2],
                calcs[i][0], calcs[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateRandomScores(numStudents);
        double[][] calculations = calculatePercentages(scores);
        String[] grades = assignGrades(calculations);

        displayScorecard(scores, calculations, grades);
        
        scanner.close();
    }
}