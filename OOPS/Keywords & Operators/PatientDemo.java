public class PatientDemo {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Ravi Kumar", 45, "Hypertension", "PAT001");
        Patient patient2 = new Patient("Sunita Devi", 32, "Diabetes", "PAT002");
        Patient patient3 = new Patient("Arun Mehta", 28, "Viral Fever", "PAT003");
        Patient patient4 = new Patient("Kavita Singh", 55, "Arthritis", "PAT004");
        
        System.out.println("Hospital: " + Patient.getHospitalName());
        System.out.println();
        
        patient1.displayPatientDetails();
        System.out.println();
        
        patient2.displayPatientDetails();
        System.out.println();
        
        patient3.displayPatientDetails();
        System.out.println();
        
        patient4.displayPatientDetails();
        System.out.println();
        
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
        
        patient3.updateAilment("Recovered - Discharged");
        System.out.println("\nAfter Patient Update:");
        patient3.displayPatientDetails();
        
        System.out.println("\nInstance Check:");
        if (patient1 instanceof Patient) {
            System.out.println("patient1 is an instance of Patient class");
            System.out.println("Patient ID: " + patient1.getPatientID());
        }
        
        Object obj = patient2;
        if (obj instanceof Patient) {
            System.out.println("obj (patient2) is an instance of Patient class");
            Patient patientObj = (Patient) obj;
            System.out.println("Patient Name: " + patientObj.getName());
            System.out.println("Age: " + patientObj.getAge());
            System.out.println("Ailment: " + patientObj.getAilment());
        }
        
        if (patient3 instanceof Patient && patient4 instanceof Patient) {
            System.out.println("All patient objects are confirmed as Patient instances");
        }
        
        System.out.println("String object is not an instance of Patient class");
    }
}

class Patient {
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;
    
    private String name;
    private int age;
    private String ailment;
    private final String patientID;
    
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    
    public static int getTotalPatients() {
        return totalPatients;
    }
    
    public static String getHospitalName() {
        return hospitalName;
    }
    
    public void displayPatientDetails() {
        System.out.println("Patient Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Ailment: " + this.ailment);
        System.out.println("Patient ID: " + this.patientID);
    }
    
    public void updateAilment(String newAilment) {
        this.ailment = newAilment;
        System.out.println("Ailment updated for patient " + this.name);
    }
    
    public String getPatientID() {
        return patientID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getAilment() {
        return this.ailment;
    }
}