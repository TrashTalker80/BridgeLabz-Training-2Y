import java.util.Random;

public class VotingEligibilityChecker {

    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        Random random = new Random();
        for (int i = 0; i < numberOfStudents; i++) {
            ages[i] = random.nextInt(90) + 10; // 2-digit ages from 10 to 99
        }
        return ages;
    }

    public static String[][] checkVotingStatus(int[] ages) {
        String[][] status = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            status[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18) {
                status[i][1] = "true";
            } else {
                status[i][1] = "false";
            }
        }
        return status;
    }

    public static void displayEligibility(String[][] data) {
        System.out.println("-------------------------");
        System.out.printf("%-10s | %s\n", "Age", "Can Vote?");
        System.out.println("-------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s | %s\n", row[0], row[1]);
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        int numberOfStudents = 10;
        int[] ages = generateRandomAges(numberOfStudents);
        String[][] eligibilityStatus = checkVotingStatus(ages);
        displayEligibility(eligibilityStatus);
    }
}