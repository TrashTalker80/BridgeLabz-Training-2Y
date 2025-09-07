import java.util.Scanner;

class StudentGradeCalculator {
    
    public static void inputStudentMarks(double[][] marks, Scanner input) {
        String[] subjects = {"Physics", "Chemistry", "Mathematics"};
        
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + " marks:");
            for (int j = 0; j < subjects.length; j++) {
                while (true) {
                    System.out.print(subjects[j] + ": ");
                    double mark = input.nextDouble();
                    
                    if (mark < 0) {
                        System.out.println("Please enter positive marks.");
                        continue;
                    }
                    
                    marks[i][j] = mark;
                    break;
                }
            }
        }
    }
    
    public static void calculatePercentages(double[][] marks, double[] percentages) {
        for (int i = 0; i < marks.length; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (total / 300.0) * 100.0;
        }
    }
    
    public static void calculateGrades(double[] percentages, String[] grades) {
        for (int i = 0; i < percentages.length; i++) {
            if (percentages[i] >= 90) {
                grades[i] = "A+";
            } else if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }
    }
    
    public static void displayResults(double[][] marks, double[] percentages, String[] grades) {
        System.out.println("\n=== STUDENT GRADE CALCULATION RESULTS ===");
        System.out.printf("%-8s %-8s %-9s %-5s %-10s %-5s%n", "Student", "Physics", "Chemistry", "Math", "Percentage", "Grade");
        System.out.println("-------------------------------------------------------");
        
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-8d %-8.2f %-9.2f %-5.2f %-10.2f %-5s%n", 
                            (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();
        
        double[][] marks = new double[numStudents][3];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        
        inputStudentMarks(marks, input);
        calculatePercentages(marks, percentages);
        calculateGrades(percentages, grades);
        displayResults(marks, percentages, grades);
        
        input.close();
    }
}
