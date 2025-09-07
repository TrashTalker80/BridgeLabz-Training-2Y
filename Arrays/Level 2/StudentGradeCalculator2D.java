import java.util.Scanner;

class StudentGradeCalculator2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        
        String[] names = new String[n];
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        String[] grades = new String[n];
        
        System.out.println("\nEnter details for " + n + " students:");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            
            System.out.print("Name: ");
            names[i] = input.next();
            
            System.out.print("Physics marks: ");
            marks[i][0] = input.nextInt();
            while (marks[i][0] < 0) {
                System.out.print("Marks must be positive. Enter again: ");
                marks[i][0] = input.nextInt();
            }
            
            System.out.print("Chemistry marks: ");
            marks[i][1] = input.nextInt();
            while (marks[i][1] < 0) {
                System.out.print("Marks must be positive. Enter again: ");
                marks[i][1] = input.nextInt();
            }
            
            System.out.print("Maths marks: ");
            marks[i][2] = input.nextInt();
            while (marks[i][2] < 0) {
                System.out.print("Marks must be positive. Enter again: ");
                marks[i][2] = input.nextInt();
            }
            
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            
            if (percentage[i] >= 80) {
                grades[i] = "A";
            } else if (percentage[i] >= 70) {
                grades[i] = "B";
            } else if (percentage[i] >= 60) {
                grades[i] = "C";
            } else if (percentage[i] >= 50) {
                grades[i] = "D";
            } else if (percentage[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        
        System.out.println("\n--- Student Grades Report ---");
        System.out.printf("%-15s %-10s %-10s %-10s %-12s %-6s\n", 
            "Name", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("--------------------------------------------------------------");
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-10d %-10d %-10d %-12.2f %-6s\n", 
                names[i], marks[i][0], marks[i][1], marks[i][2], percentage[i], grades[i]);
        }
        
        input.close();
    }
}
