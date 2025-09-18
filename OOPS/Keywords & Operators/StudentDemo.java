public class StudentDemo {
    public static void main(String[] args) {
        Student student1 = new Student("Ananya Gupta", 2023001, "A+");
        Student student2 = new Student("Rohit Verma", 2023002, "A");
        Student student3 = new Student("Sneha Reddy", 2023003, "B+");
        Student student4 = new Student("Arjun Singh", 2023004, "A");
        
        System.out.println("University: " + Student.getUniversityName());
        System.out.println();
        
        student1.displayStudentDetails();
        System.out.println();
        
        student2.displayStudentDetails();
        System.out.println();
        
        student3.displayStudentDetails();
        System.out.println();
        
        student4.displayStudentDetails();
        System.out.println();
        
        Student.displayTotalStudents();
        
        student3.updateGrade("A");
        System.out.println("\nAfter Grade Update:");
        student3.displayStudentDetails();
        
        System.out.println("\nInstance Check:");
        if (student1 instanceof Student) {
            System.out.println("student1 is an instance of Student class");
            System.out.println("Roll Number: " + student1.getRollNumber());
        }
        
        Object obj = student2;
        if (obj instanceof Student) {
            System.out.println("obj (student2) is an instance of Student class");
            Student studentObj = (Student) obj;
            System.out.println("Student Name: " + studentObj.getName());
            System.out.println("Current Grade: " + studentObj.getGrade());
        }
        
        if (student3 instanceof Student && student4 instanceof Student) {
            System.out.println("All objects are confirmed as Student instances");
        }
    }
}

class Student {
    private static String universityName = "National Institute of Technology";
    private static int totalStudents = 0;
    
    private String name;
    private final int rollNumber;
    private String grade;
    
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    
    public static void displayTotalStudents() {
        System.out.println("Total Students enrolled in " + universityName + ": " + totalStudents);
    }
    
    public static String getUniversityName() {
        return universityName;
    }
    
    public void displayStudentDetails() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Grade: " + this.grade);
    }
    
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated for " + this.name);
    }
    
    public int getRollNumber() {
        return rollNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getGrade() {
        return this.grade;
    }
}