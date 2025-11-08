import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}

class Truck extends Vehicle {
    public Truck(String model) {
        super(model);
    }
}

class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }
}

class Bike extends Vehicle {
    public Bike(String model) {
        super(model);
    }
}

class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
        System.out.println("Added: " + vehicle);
    }

    public void showFleet() {
        System.out.println("Fleet vehicles:");
        for (T vehicle : fleet) {
            System.out.println(" - " + vehicle);
        }
    }
}

public class GenericFleetManager {
    public static void main(String[] args) {
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Volvo FH16"));
        truckFleet.addVehicle(new Truck("Mercedes Actros"));
        truckFleet.showFleet();

        System.out.println();

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Yamaha R15"));
        bikeFleet.addVehicle(new Bike("Honda CBR"));
        bikeFleet.showFleet();

        System.out.println();

        FleetManager<Car> carFleet = new FleetManager<>();
        carFleet.addVehicle(new Car("Tesla Model 3"));
        carFleet.addVehicle(new Car("BMW i4"));
        carFleet.showFleet();
    }
}
