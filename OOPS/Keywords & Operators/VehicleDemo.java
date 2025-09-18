public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Rajesh Kumar", "Car", "MH12AB1234");
        Vehicle vehicle2 = new Vehicle("Priya Sharma", "Motorcycle", "DL08CD5678");
        Vehicle vehicle3 = new Vehicle("Amit Patel", "SUV", "GJ06EF9012");
        
        System.out.println("Initial Registration Fee: Rs. " + Vehicle.getRegistrationFee());
        System.out.println();
        
        vehicle1.displayVehicleDetails();
        System.out.println();
        
        vehicle2.displayVehicleDetails();
        System.out.println();
        
        vehicle3.displayVehicleDetails();
        System.out.println();
        
        Vehicle.updateRegistrationFee(1500.0);
        System.out.println("Updated Registration Fee: Rs. " + Vehicle.getRegistrationFee());
        
        Vehicle vehicle4 = new Vehicle("Sneha Reddy", "Scooter", "KA03GH3456");
        System.out.println("\nNew Vehicle Registered:");
        vehicle4.displayVehicleDetails();
        
        System.out.println("\nTotal Vehicles Registered: " + Vehicle.getTotalVehicles());
        
        System.out.println("\nInstance Check:");
        if (vehicle1 instanceof Vehicle) {
            System.out.println("vehicle1 is an instance of Vehicle class");
            System.out.println("Registration Number: " + vehicle1.getRegistrationNumber());
        }
        
        Object obj = vehicle2;
        if (obj instanceof Vehicle) {
            System.out.println("obj (vehicle2) is an instance of Vehicle class");
            Vehicle vehicleObj = (Vehicle) obj;
            System.out.println("Owner: " + vehicleObj.getOwnerName());
            System.out.println("Vehicle Type: " + vehicleObj.getVehicleType());
        }
        
        if (vehicle3 instanceof Vehicle && vehicle4 instanceof Vehicle) {
            System.out.println("All objects are confirmed as Vehicle instances");
        }
    }
}

class Vehicle {
    private static double registrationFee = 1000.0;
    private static int totalVehicles = 0;
    
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;
    
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        totalVehicles++;
    }
    
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    
    public static double getRegistrationFee() {
        return registrationFee;
    }
    
    public static int getTotalVehicles() {
        return totalVehicles;
    }
    
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Vehicle Type: " + this.vehicleType);
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Registration Fee: Rs. " + registrationFee);
    }
    
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    
    public String getOwnerName() {
        return this.ownerName;
    }
    
    public String getVehicleType() {
        return this.vehicleType;
    }
}