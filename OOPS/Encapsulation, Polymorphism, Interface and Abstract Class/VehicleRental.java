import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public abstract double calculateRentalCost(int days);
    
    public void displayVehicleInfo(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Daily Rental Rate: $" + String.format("%.2f", rentalRate));
        System.out.println("Rental Cost for " + days + " days: $" + String.format("%.2f", calculateRentalCost(days)));
        
        if (this instanceof Insurable) {
            Insurable insurableVehicle = (Insurable) this;
            System.out.println("Insurance Cost: $" + String.format("%.2f", insurableVehicle.calculateInsurance()));
            System.out.println(insurableVehicle.getInsuranceDetails());
        }
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) {
            this.rentalRate = rentalRate;
        }
    }
}

class Car extends Vehicle implements Insurable {
    private String model;
    private int seatingCapacity;
    private static final double INSURANCE_RATE = 15.0;
    
    public Car(String vehicleNumber, double rentalRate, String model, int seatingCapacity) {
        super(vehicleNumber, "Car", rentalRate);
        this.model = model;
        this.seatingCapacity = seatingCapacity;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getRentalRate() * days;
        if (days > 7) {
            baseCost *= 0.9;
        }
        return baseCost;
    }
    
    @Override
    public double calculateInsurance() {
        return INSURANCE_RATE * seatingCapacity;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance - Model: " + model + ", Seats: " + seatingCapacity + ", Rate per seat: $" + INSURANCE_RATE;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    
    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity > 0) {
            this.seatingCapacity = seatingCapacity;
        }
    }
}

class Bike extends Vehicle implements Insurable {
    private String bikeType;
    private boolean hasHelmet;
    private static final double BASE_INSURANCE = 25.0;
    
    public Bike(String vehicleNumber, double rentalRate, String bikeType, boolean hasHelmet) {
        super(vehicleNumber, "Bike", rentalRate);
        this.bikeType = bikeType;
        this.hasHelmet = hasHelmet;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getRentalRate() * days;
        if (!hasHelmet) {
            baseCost += 5 * days;
        }
        return baseCost;
    }
    
    @Override
    public double calculateInsurance() {
        return BASE_INSURANCE;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance - Type: " + bikeType + ", Helmet included: " + (hasHelmet ? "Yes" : "No");
    }
    
    public String getBikeType() {
        return bikeType;
    }
    
    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
    
    public boolean isHasHelmet() {
        return hasHelmet;
    }
    
    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }
}

class Truck extends Vehicle {
    private double loadCapacity;
    private boolean hasDriver;
    private static final double DRIVER_COST_PER_DAY = 50.0;
    
    public Truck(String vehicleNumber, double rentalRate, double loadCapacity, boolean hasDriver) {
        super(vehicleNumber, "Truck", rentalRate);
        this.loadCapacity = loadCapacity;
        this.hasDriver = hasDriver;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getRentalRate() * days;
        if (hasDriver) {
            baseCost += DRIVER_COST_PER_DAY * days;
        }
        if (loadCapacity > 10) {
            baseCost *= 1.2;
        }
        return baseCost;
    }
    
    public double getLoadCapacity() {
        return loadCapacity;
    }
    
    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity > 0) {
            this.loadCapacity = loadCapacity;
        }
    }
    
    public boolean isHasDriver() {
        return hasDriver;
    }
    
    public void setHasDriver(boolean hasDriver) {
        this.hasDriver = hasDriver;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car sedan = new Car("CAR-001", 50.0, "Toyota Camry", 5);
        Car suv = new Car("CAR-002", 80.0, "Honda CR-V", 7);
        
        Bike sportsBike = new Bike("BIKE-001", 30.0, "Sports", true);
        Bike scooter = new Bike("BIKE-002", 20.0, "Scooter", false);
        
        Truck smallTruck = new Truck("TRUCK-001", 100.0, 5.0, false);
        Truck largeTruck = new Truck("TRUCK-002", 150.0, 15.0, true);
        
        vehicles.add(sedan);
        vehicles.add(suv);
        vehicles.add(sportsBike);
        vehicles.add(scooter);
        vehicles.add(smallTruck);
        vehicles.add(largeTruck);
        
        System.out.println("=== Vehicle Rental System ===\n");
        
        int rentalDays = 5;
        double totalRentalCost = 0;
        double totalInsuranceCost = 0;
        
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo(rentalDays);
            System.out.println("-------------------");
            
            totalRentalCost += vehicle.calculateRentalCost(rentalDays);
            
            if (vehicle instanceof Insurable) {
                totalInsuranceCost += ((Insurable) vehicle).calculateInsurance();
            }
        }
        
        System.out.println("\n=== Rental Summary ===");
        System.out.println("Total Vehicles: " + vehicles.size());
        System.out.println("Rental Period: " + rentalDays + " days");
        System.out.println("Total Rental Cost: $" + String.format("%.2f", totalRentalCost));
        System.out.println("Total Insurance Cost: $" + String.format("%.2f", totalInsuranceCost));
        System.out.println("Grand Total: $" + String.format("%.2f", totalRentalCost + totalInsuranceCost));
    }
}