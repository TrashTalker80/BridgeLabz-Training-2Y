package college.faculty;

public class Faculty {
    private int facultyId;
    private String name;
    private String department;
    private String specialization;

    public Faculty(int facultyId, String name, String department, String specialization) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
        this.specialization = specialization;
    }

    public void displayFacultyInfo() {
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Specialization: " + specialization);
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }
}
