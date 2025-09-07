import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physics = input.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = input.nextInt();
        System.out.print("Enter marks for Maths: ");
        int maths = input.nextInt();

        double averageMark = (physics + chemistry + maths) / 3.0;

        System.out.printf("Average Mark: %.2f\n", averageMark);

        if (averageMark >= 80) {
            System.out.println("Grade: A");
            System.out.println("Remarks: Level 4, above agency-normalized standards");
        } else if (averageMark >= 70) {
            System.out.println("Grade: B");
            System.out.println("Remarks: Level 3, at agency-normalized standards");
        } else if (averageMark >= 60) {
            System.out.println("Grade: C");
            System.out.println("Remarks: Level 2, below, but approaching agency-normalized standards");
        } else if (averageMark >= 50) {
            System.out.println("Grade: D");
            System.out.println("Remarks: Level 1, well below agency-normalized standards");
        } else if (averageMark >= 40) {
            System.out.println("Grade: E");
            System.out.println("Remarks: Level 1-, too below agency-normalized standards");
        } else {
            System.out.println("Grade: R");
            System.out.println("Remarks: Remedial standards");
        }
        input.close();
    }
}