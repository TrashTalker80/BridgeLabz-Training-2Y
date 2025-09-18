import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;
    private boolean isAvailable;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Base Station";
        this.isAvailable = true;
    }
    
    public abstract double calculateFare(double distance);
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per KM: $" + String.format("%.2f", ratePerKm));
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Status: " + (isAvailable ? "Available" : "On Trip"));
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        }
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Car extends Vehicle implements GPS {
    private String carModel;
    private int seatingCapacity;
    private static final double BASE_FARE = 5.0;
    private static final double SURGE_MULTIPLIER = 1.5;
    private boolean isSurgeTime;
    
    public Car(String vehicleId, String driverName, double ratePerKm, String carModel, int seatingCapacity) {
        super(vehicleId, driverName, ratePerKm);
        this.carModel = carModel;
        this.seatingCapacity = seatingCapacity;
        this.isSurgeTime = false;
    }
    
    @Override
    public double calculateFare(double distance) {
        double baseFare = BASE_FARE + (getRatePerKm() * distance);
        if (isSurgeTime) {
            baseFare *= SURGE_MULTIPLIER;
        }
        if (seatingCapacity > 4) {
            baseFare *= 1.2;
        }
        return Math.round(baseFare * 100.0) / 100.0;
    }
    
    @Override
    public String getCurrentLocation() {
        return "GPS: " + super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Car location updated to: " + newLocation);
    }
    
    public String getCarModel() {
        return carModel;
    }
    
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    
    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity > 0) {
            this.seatingCapacity = seatingCapacity;
        }
    }
    
    public void setSurgeTime(boolean surgeTime) {
        isSurgeTime = surgeTime;
    }
}

class Bike extends Vehicle implements GPS {
    private boolean hasHelmet;
    private String bikeType;
    private static final double BASE_FARE = 2.0;
    
    public Bike(String vehicleId, String driverName, double ratePerKm, String bikeType, boolean hasHelmet) {
        super(vehicleId, driverName, ratePerKm);
        this.bikeType = bikeType;
        this.hasHelmet = hasHelmet;
    }
    
    @Override
    public double calculateFare(double distance) {
        double fare = BASE_FARE + (getRatePerKm() * distance);
        if (distance > 10) {
            fare *= 0.9;
        }
        return Math.round(fare * 100.0) / 100.0;
    }
    
    @Override
    public String getCurrentLocation() {
        return "GPS: " + super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Bike location updated to: " + newLocation);
    }
    
    public boolean hasHelmet() {
        return hasHelmet;
    }
    
    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }
    
    public String getBikeType() {
        return bikeType;
    }
    
    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}

class Auto extends Vehicle implements GPS {
    private boolean hasAC;
    private String permitType;
    private static final double BASE_FARE = 3.0;
    private static final double NIGHT_CHARGE_MULTIPLIER = 1.25;
    private boolean isNightTime;
    
    public Auto(String vehicleId, String driverName, double ratePerKm, String permitType, boolean hasAC) {
        super(vehicleId, driverName, ratePerKm);
        this.permitType = permitType;
        this.hasAC = hasAC;
        this.isNightTime = false;
    }
    
    @Override
    public double calculateFare(double distance) {
        double fare = BASE_FARE + (getRatePerKm() * distance);
        if (hasAC) {
            fare *= 1.15;
        }
        if (isNightTime) {
            fare *= NIGHT_CHARGE_MULTIPLIER;
        }
        return Math.round(fare * 100.0) / 100.0;
    }
    
    @Override
    public String getCurrentLocation() {
        return "GPS: " + super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Auto location updated to: " + newLocation);
    }
    
    public boolean hasAC() {
        return hasAC;
    }
    
    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }
    
    public String getPermitType() {
        return permitType;
    }
    
    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }
    
    public void setNightTime(boolean nightTime) {
        isNightTime = nightTime;
    }
}

class Ride {
    private String rideId;
    private Vehicle vehicle;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private String status;
    
    public Ride(String rideId, Vehicle vehicle, String pickupLocation, String dropLocation, double distance) {
        this.rideId = rideId;
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
        this.fare = vehicle.calculateFare(distance);
        this.status = "Booked";
    }
    
    public void displayRideDetails() {
        System.out.println("\n--- Ride Details ---");
        System.out.println("Ride ID: " + rideId);
        System.out.println("Vehicle Type: " + vehicle.getClass().getSimpleName());
        System.out.println("Driver: " + vehicle.getDriverName());
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Drop: " + dropLocation);
        System.out.println("Distance: " + distance + " KM");
        System.out.println("Fare: $" + String.format("%.2f", fare));
        System.out.println("Status: " + status);
    }
    
    public void startRide() {
        status = "In Progress";
        vehicle.setAvailable(false);
        if (vehicle instanceof GPS) {
            ((GPS) vehicle).updateLocation(pickupLocation);
        }
    }
    
    public void completeRide() {
        status = "Completed";
        vehicle.setAvailable(true);
        if (vehicle instanceof GPS) {
            ((GPS) vehicle).updateLocation(dropLocation);
        }
    }
}

public class RideHailing {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car sedan = new Car("CAR001", "John Driver", 8.0, "Toyota Camry", 4);
        Car suv = new Car("CAR002", "Sarah Driver", 10.0, "Honda CR-V", 7);
        suv.setSurgeTime(true);
        
        Bike sportsBike = new Bike("BIKE001", "Mike Rider", 4.0, "Sports", true);
        Bike scooter = new Bike("BIKE002", "Tom Rider", 3.5, "Scooter", true);
        
        Auto regularAuto = new Auto("AUTO001", "Ram Kumar", 5.0, "City", false);
        Auto acAuto = new Auto("AUTO002", "Shyam Singh", 6.0, "City", true);
        acAuto.setNightTime(true);
        
        vehicles.add(sedan);
        vehicles.add(suv);
        vehicles.add(sportsBike);
        vehicles.add(scooter);
        vehicles.add(regularAuto);
        vehicles.add(acAuto);
        
        System.out.println("=== Ride-Hailing Application ===\n");
        
        System.out.println("--- Available Vehicles ---");
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Sample Fare (10 KM): $" + String.format("%.2f", vehicle.calculateFare(10)));
            System.out.println("-------------------");
        }
        
        System.out.println("\n--- Booking Rides ---");
        
        Ride ride1 = new Ride("RIDE001", sedan, "Downtown", "Airport", 25.0);
        ride1.displayRideDetails();
        ride1.startRide();
        
        Ride ride2 = new Ride("RIDE002", sportsBike, "Mall", "University", 8.0);
        ride2.displayRideDetails();
        ride2.startRide();
        
        Ride ride3 = new Ride("RIDE003", acAuto, "Station", "Hospital", 12.0);
        ride3.displayRideDetails();
        ride3.startRide();
        
        System.out.println("\n--- Completing Rides ---");
        ride1.completeRide();
        ride2.completeRide();
        
        System.out.println("\n--- Updated Vehicle Status ---");
        System.out.println("Vehicle " + sedan.getVehicleId() + " - Location: " + sedan.getCurrentLocation());
        System.out.println("Vehicle " + sportsBike.getVehicleId() + " - Location: " + sportsBike.getCurrentLocation());
        System.out.println("Vehicle " + acAuto.getVehicleId() + " - Available: " + acAuto.isAvailable());
        
        System.out.println("\n=== Ride Summary ===");
        List<Ride> allRides = Arrays.asList(ride1, ride2, ride3);
        double totalRevenue = 0;
        
        for (Ride ride : allRides) {
            totalRevenue += ride.fare;
        }
        
        System.out.println("Total Rides: " + allRides.size());
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        System.out.println("Average Fare per Ride: $" + String.format("%.2f", totalRevenue / allRides.size()));
        
        int availableVehicles = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles++;
            }
        }
        System.out.println("Available Vehicles: " + availableVehicles + "/" + vehicles.size());
    }
}