import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class PatientRec {
    private String patientId;
    private String name;

    public PatientRec(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientRec patient = (PatientRec) o;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    @Override
    public String toString() {
        return patientId + " - " + name;
    }
}

public class HospitalPatientManagement {
    private Set<PatientRec> admittedPatients;
    private Queue<PatientRec> treatmentQueue;
    private Stack<PatientRec> dischargedPatients;
    private List<PatientRec> patientHistory;

    public HospitalPatientManagement() {
        admittedPatients = new HashSet<>();
        treatmentQueue = new LinkedList<>();
        dischargedPatients = new Stack<>();
        patientHistory = new ArrayList<>();
    }

    public void admitPatient(PatientRec patient) {
        if (admittedPatients.add(patient)) {
            treatmentQueue.add(patient);
            patientHistory.add(patient);
            System.out.println("Patient admitted: " + patient);
        } else {
            System.out.println("Patient already admitted: " + patient);
        }
    }

    public void treatPatients() {
        System.out.println("\nTreating patients:");
        while (!treatmentQueue.isEmpty()) {
            PatientRec patient = treatmentQueue.poll();
            System.out.println("Treating: " + patient);
            dischargedPatients.push(patient);
            admittedPatients.remove(patient);
        }
    }

    public void reAdmit() {
        if (!dischargedPatients.isEmpty()) {
            PatientRec patient = dischargedPatients.pop();
            admittedPatients.add(patient);
            treatmentQueue.add(patient);
            System.out.println("\nRe-admitted: " + patient);
        }
    }

    public static void main(String[] args) {
        HospitalPatientManagement system = new HospitalPatientManagement();

        system.admitPatient(new PatientRec("P001", "John"));
        system.admitPatient(new PatientRec("P002", "Alice"));
        system.admitPatient(new PatientRec("P001", "John Duplicate"));

        system.treatPatients();
        system.reAdmit();
    }
}
