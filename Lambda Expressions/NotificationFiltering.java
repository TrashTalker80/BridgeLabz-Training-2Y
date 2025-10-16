import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class PatientAlert {
    private String patientName;
    private String alertType;
    private String message;
    private int priority;
    
    public PatientAlert(String patientName, String alertType, String message, int priority) {
        this.patientName = patientName;
        this.alertType = alertType;
        this.message = message;
        this.priority = priority;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public String getAlertType() {
        return alertType;
    }
    
    public String getMessage() {
        return message;
    }
    
    public int getPriority() {
        return priority;
    }
    
    @Override
    public String toString() {
        return String.format("[%s - Priority %d] %s: %s", 
                           alertType, priority, patientName, message);
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<PatientAlert> alerts = new ArrayList<>();
        alerts.add(new PatientAlert("John Doe", "CRITICAL", "Blood pressure dangerously high", 1));
        alerts.add(new PatientAlert("Jane Smith", "MEDICATION", "Time for medication", 3));
        alerts.add(new PatientAlert("Bob Johnson", "EMERGENCY", "Heart rate abnormal", 1));
        alerts.add(new PatientAlert("Alice Williams", "APPOINTMENT", "Upcoming doctor appointment", 4));
        alerts.add(new PatientAlert("Charlie Brown", "CRITICAL", "Oxygen level low", 1));
        alerts.add(new PatientAlert("Diana Prince", "ROUTINE", "Daily checkup reminder", 5));
        alerts.add(new PatientAlert("Eve Davis", "MEDICATION", "Time for medication", 3));
        
        System.out.println("Hospital Patient Alert Filtering System");
        System.out.println("========================================\n");
        
        System.out.println("All Alerts:");
        alerts.forEach(System.out::println);
        
        Predicate<PatientAlert> criticalAlerts = alert -> alert.getPriority() == 1;
        System.out.println("\n--- Critical Alerts Only (Priority 1) ---");
        alerts.stream()
              .filter(criticalAlerts)
              .forEach(System.out::println);
        
        Predicate<PatientAlert> medicationAlerts = alert -> alert.getAlertType().equals("MEDICATION");
        System.out.println("\n--- Medication Alerts Only ---");
        alerts.stream()
              .filter(medicationAlerts)
              .forEach(System.out::println);
        
        Predicate<PatientAlert> highPriorityAlerts = alert -> alert.getPriority() <= 2;
        System.out.println("\n--- High Priority Alerts (Priority 1-2) ---");
        alerts.stream()
              .filter(highPriorityAlerts)
              .forEach(System.out::println);
        
        Predicate<PatientAlert> emergencyCritical = alert -> 
            alert.getAlertType().equals("EMERGENCY") || alert.getAlertType().equals("CRITICAL");
        System.out.println("\n--- Emergency or Critical Alerts ---");
        alerts.stream()
              .filter(emergencyCritical)
              .forEach(System.out::println);
        
        Predicate<PatientAlert> lowPriorityAlerts = alert -> alert.getPriority() >= 4;
        System.out.println("\n--- Low Priority Alerts (Priority 4-5) ---");
        alerts.stream()
              .filter(lowPriorityAlerts)
              .forEach(System.out::println);
    }
}
