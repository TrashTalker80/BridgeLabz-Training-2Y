import java.util.Arrays;
import java.util.List;

class Patient {
    private String patientId;
    private String name;
    
    public Patient(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
}

class PatientIdPrinter {
    public static void printPatientId(Patient patient) {
        System.out.println("Patient ID: " + patient.getPatientId() + " - " + patient.getName());
    }
    
    public void printId(Patient patient) {
        System.out.println("ID: " + patient.getPatientId());
    }
}

public class HospitalPatientIdPrinting {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("PAT001", "John Doe"),
            new Patient("PAT002", "Jane Smith"),
            new Patient("PAT003", "Bob Johnson"),
            new Patient("PAT004", "Alice Williams"),
            new Patient("PAT005", "Charlie Brown")
        );
        
        System.out.println("Hospital Patient ID Verification");
        System.out.println("=================================\n");
        
        System.out.println("Method 1: Using static method reference");
        patients.forEach(PatientIdPrinter::printPatientId);
        
        System.out.println("\nMethod 2: Using instance method reference");
        PatientIdPrinter printer = new PatientIdPrinter();
        patients.forEach(printer::printId);
        
        System.out.println("\nMethod 3: Using instance method reference with arbitrary object");
        patients.stream()
                .map(Patient::getPatientId)
                .forEach(System.out::println);
    }
}
