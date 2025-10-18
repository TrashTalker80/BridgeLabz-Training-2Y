package college.department;

public class Department {
    private String departmentCode;
    private String departmentName;
    private String hodName;
    private int numberOfFaculty;

    public Department(String departmentCode, String departmentName, String hodName, int numberOfFaculty) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.hodName = hodName;
        this.numberOfFaculty = numberOfFaculty;
    }

    public void displayDepartmentInfo() {
        System.out.println("Department Code: " + departmentCode);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Head of Department: " + hodName);
        System.out.println("Number of Faculty: " + numberOfFaculty);
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
