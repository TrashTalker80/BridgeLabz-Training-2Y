import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;
    private String diagnosis;
    
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
        this.diagnosis = "";
    }
    
    public abstract double calculateBill();
    
    public void getPatientDetails() {
        System.out.println("Patient ID: " + maskPatientId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + (diagnosis.isEmpty() ? "Not diagnosed yet" : diagnosis));
        System.out.println("Bill Amount: $" + String.format("%.2f", calculateBill()));
    }
    
    private String maskPatientId() {
        if (patientId == null || patientId.length() <= 4) {
            return patientId;
        }
        return patientId.substring(0, 2) + "****" + patientId.substring(patientId.length() - 2);
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    
    protected List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }
    
    protected void addToMedicalHistory(String record) {
        medicalHistory.add(record);
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        addToMedicalHistory("Diagnosed with: " + diagnosis);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int numberOfDays;
    private String roomType;
    private double surgeryCharges;
    private static final double GENERAL_ROOM_RATE = 200.0;
    private static final double PRIVATE_ROOM_RATE = 500.0;
    private static final double ICU_ROOM_RATE = 1000.0;
    private static final double MEDICATION_PER_DAY = 50.0;
    
    public InPatient(String patientId, String name, int age, int numberOfDays, String roomType, double surgeryCharges) {
        super(patientId, name, age);
        this.numberOfDays = numberOfDays;
        this.roomType = roomType;
        this.surgeryCharges = surgeryCharges;
    }
    
    @Override
    public double calculateBill() {
        double roomCharges = getRoomRate() * numberOfDays;
        double medicationCharges = MEDICATION_PER_DAY * numberOfDays;
        return roomCharges + medicationCharges + surgeryCharges;
    }
    
    private double getRoomRate() {
        switch (roomType.toLowerCase()) {
            case "private":
                return PRIVATE_ROOM_RATE;
            case "icu":
                return ICU_ROOM_RATE;
            default:
                return GENERAL_ROOM_RATE;
        }
    }
    
    @Override
    public void addRecord(String record) {
        addToMedicalHistory("[IN-PATIENT] " + record);
    }
    
    @Override
    public List<String> viewRecords() {
        System.out.println("Medical Records (In-Patient):");
        List<String> records = getMedicalHistory();
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }
        return records;
    }
    
    public int getNumberOfDays() {
        return numberOfDays;
    }
    
    public void setNumberOfDays(int numberOfDays) {
        if (numberOfDays > 0) {
            this.numberOfDays = numberOfDays;
        }
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public double getSurgeryCharges() {
        return surgeryCharges;
    }
    
    public void setSurgeryCharges(double surgeryCharges) {
        if (surgeryCharges >= 0) {
            this.surgeryCharges = surgeryCharges;
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private int numberOfVisits;
    private double consultationFee;
    private double labTestCharges;
    private static final double PHARMACY_CHARGES_PER_VISIT = 30.0;
    
    public OutPatient(String patientId, String name, int age, int numberOfVisits, double consultationFee, double labTestCharges) {
        super(patientId, name, age);
        this.numberOfVisits = numberOfVisits;
        this.consultationFee = consultationFee;
        this.labTestCharges = labTestCharges;
    }
    
    @Override
    public double calculateBill() {
        double totalConsultationFee = consultationFee * numberOfVisits;
        double pharmacyCharges = PHARMACY_CHARGES_PER_VISIT * numberOfVisits;
        return totalConsultationFee + labTestCharges + pharmacyCharges;
    }
    
    @Override
    public void addRecord(String record) {
        addToMedicalHistory("[OUT-PATIENT] " + record);
    }
    
    @Override
    public List<String> viewRecords() {
        System.out.println("Medical Records (Out-Patient):");
        List<String> records = getMedicalHistory();
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }
        return records;
    }
    
    public int getNumberOfVisits() {
        return numberOfVisits;
    }
    
    public void setNumberOfVisits(int numberOfVisits) {
        if (numberOfVisits > 0) {
            this.numberOfVisits = numberOfVisits;
        }
    }
    
    public double getConsultationFee() {
        return consultationFee;
    }
    
    public void setConsultationFee(double consultationFee) {
        if (consultationFee > 0) {
            this.consultationFee = consultationFee;
        }
    }
    
    public double getLabTestCharges() {
        return labTestCharges;
    }
    
    public void setLabTestCharges(double labTestCharges) {
        if (labTestCharges >= 0) {
            this.labTestCharges = labTestCharges;
        }
    }
}

public class PatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inPatient1 = new InPatient("PAT10001", "John Smith", 45, 7, "private", 5000);
        inPatient1.setDiagnosis("Heart Surgery");
        inPatient1.addRecord("Admitted on 2024-01-15");
        inPatient1.addRecord("Surgery performed on 2024-01-16");
        inPatient1.addRecord("Post-surgery recovery in progress");
        
        InPatient inPatient2 = new InPatient("PAT10002", "Mary Johnson", 60, 3, "icu", 0);
        inPatient2.setDiagnosis("Severe Pneumonia");
        inPatient2.addRecord("Emergency admission on 2024-01-20");
        inPatient2.addRecord("Oxygen therapy started");
        
        OutPatient outPatient1 = new OutPatient("PAT20001", "Bob Williams", 30, 5, 100, 500);
        outPatient1.setDiagnosis("Chronic Migraine");
        outPatient1.addRecord("First consultation on 2024-01-10");
        outPatient1.addRecord("MRI scan performed");
        outPatient1.addRecord("Prescribed medication for 3 months");
        
        OutPatient outPatient2 = new OutPatient("PAT20002", "Alice Brown", 25, 2, 80, 200);
        outPatient2.setDiagnosis("Seasonal Allergies");
        outPatient2.addRecord("Allergy tests conducted");
        outPatient2.addRecord("Antihistamines prescribed");
        
        patients.add(inPatient1);
        patients.add(inPatient2);
        patients.add(outPatient1);
        patients.add(outPatient2);
        
        System.out.println("=== Hospital Patient Management System ===\n");
        
        for (Patient patient : patients) {
            System.out.println("--- Patient Information ---");
            patient.getPatientDetails();
            
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) patient;
                medicalRecord.viewRecords();
            }
            
            System.out.println("\nDetailed Bill Breakdown:");
            if (patient instanceof InPatient) {
                InPatient ip = (InPatient) patient;
                System.out.println("Room Type: " + ip.getRoomType());
                System.out.println("Days: " + ip.getNumberOfDays());
                System.out.println("Surgery Charges: $" + String.format("%.2f", ip.getSurgeryCharges()));
            } else if (patient instanceof OutPatient) {
                OutPatient op = (OutPatient) patient;
                System.out.println("Visits: " + op.getNumberOfVisits());
                System.out.println("Consultation Fee per visit: $" + String.format("%.2f", op.getConsultationFee()));
                System.out.println("Lab Test Charges: $" + String.format("%.2f", op.getLabTestCharges()));
            }
            System.out.println("Total Bill: $" + String.format("%.2f", patient.calculateBill()));
            System.out.println("=======================\n");
        }
        
        System.out.println("=== Hospital Summary ===");
        int inPatientCount = 0;
        int outPatientCount = 0;
        double totalRevenue = 0;
        
        for (Patient patient : patients) {
            totalRevenue += patient.calculateBill();
            if (patient instanceof InPatient) {
                inPatientCount++;
            } else if (patient instanceof OutPatient) {
                outPatientCount++;
            }
        }
        
        System.out.println("Total Patients: " + patients.size());
        System.out.println("In-Patients: " + inPatientCount);
        System.out.println("Out-Patients: " + outPatientCount);
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        System.out.println("Average Bill per Patient: $" + String.format("%.2f", totalRevenue / patients.size()));
    }
}