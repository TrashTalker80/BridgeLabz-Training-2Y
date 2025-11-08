import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Driver {
    private String driverId;
    private String name;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(driverId, driver.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId);
    }

    @Override
    public String toString() {
        return driverId + " - " + name;
    }
}

class RideRequest implements Comparable<RideRequest> {
    private String requestId;
    private String passenger;
    private int priority;

    public RideRequest(String requestId, String passenger, int priority) {
        this.requestId = requestId;
        this.passenger = passenger;
        this.priority = priority;
    }

    @Override
    public int compareTo(RideRequest other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return requestId + " - " + passenger + " (Priority: " + priority + ")";
    }
}

class Ride {
    private String rideId;
    private String driver;
    private String passenger;

    public Ride(String rideId, String driver, String passenger) {
        this.rideId = rideId;
        this.driver = driver;
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return rideId + ": " + driver + " -> " + passenger;
    }
}

public class RideSharingDispatchSystem {
    private Queue<RideRequest> pendingRequests;
    private Set<Driver> availableDrivers;
    private List<Ride> completedRides;
    private PriorityQueue<RideRequest> priorityRequests;

    public RideSharingDispatchSystem() {
        pendingRequests = new LinkedList<>();
        availableDrivers = new HashSet<>();
        completedRides = new ArrayList<>();
        priorityRequests = new PriorityQueue<>();
    }

    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
        System.out.println("Driver added: " + driver);
    }

    public void addRideRequest(RideRequest request) {
        pendingRequests.add(request);
        priorityRequests.add(request);
        System.out.println("Ride request added: " + request);
    }

    public void assignRides() {
        System.out.println("\nAssigning rides by priority:");
        while (!priorityRequests.isEmpty() && !availableDrivers.isEmpty()) {
            RideRequest request = priorityRequests.poll();
            Driver driver = availableDrivers.iterator().next();
            availableDrivers.remove(driver);
            Ride ride = new Ride("R" + completedRides.size(), driver.toString(), request.toString());
            completedRides.add(ride);
            System.out.println("Assigned: " + ride);
        }
    }

    public void displayCompletedRides() {
        System.out.println("\nCompleted rides:");
        for (Ride ride : completedRides) {
            System.out.println(ride);
        }
    }

    public static void main(String[] args) {
        RideSharingDispatchSystem system = new RideSharingDispatchSystem();

        system.addDriver(new Driver("D001", "John"));
        system.addDriver(new Driver("D002", "Alice"));

        system.addRideRequest(new RideRequest("REQ001", "Passenger A", 2));
        system.addRideRequest(new RideRequest("REQ002", "Passenger B", 5));
        system.addRideRequest(new RideRequest("REQ003", "Passenger C", 3));

        system.assignRides();
        system.displayCompletedRides();
    }
}
