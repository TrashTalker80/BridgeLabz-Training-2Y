import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Package {
    private String packageId;
    private String destination;

    public Package(String packageId, String destination) {
        this.packageId = packageId;
        this.destination = destination;
    }

    public String getPackageId() {
        return packageId;
    }

    @Override
    public String toString() {
        return packageId + " -> " + destination;
    }
}

public class WarehouseDeliveryTracking {
    private Queue<Package> pendingDeliveries;
    private Set<String> uniquePackageIds;
    private List<Package> deliveredPackages;
    private Stack<Package> returnedPackages;

    public WarehouseDeliveryTracking() {
        pendingDeliveries = new LinkedList<>();
        uniquePackageIds = new HashSet<>();
        deliveredPackages = new ArrayList<>();
        returnedPackages = new Stack<>();
    }

    public void addPackage(Package pkg) {
        if (uniquePackageIds.add(pkg.getPackageId())) {
            pendingDeliveries.add(pkg);
            System.out.println("Package added: " + pkg);
        } else {
            System.out.println("Duplicate package ID: " + pkg.getPackageId());
        }
    }

    public void processDeliveries() {
        System.out.println("\nProcessing deliveries:");
        while (!pendingDeliveries.isEmpty()) {
            Package pkg = pendingDeliveries.poll();
            if (Math.random() > 0.2) {
                deliveredPackages.add(pkg);
                System.out.println("Delivered: " + pkg);
            } else {
                returnedPackages.push(pkg);
                System.out.println("Returned: " + pkg);
            }
        }
    }

    public void displaySummary() {
        System.out.println("\n--- Delivery Summary ---");
        System.out.println("Delivered: " + deliveredPackages.size());
        System.out.println("Returned: " + returnedPackages.size());
    }

    public static void main(String[] args) {
        WarehouseDeliveryTracking system = new WarehouseDeliveryTracking();

        system.addPackage(new Package("PKG001", "Mumbai"));
        system.addPackage(new Package("PKG002", "Delhi"));
        system.addPackage(new Package("PKG001", "Duplicate"));
        system.addPackage(new Package("PKG003", "Bangalore"));

        system.processDeliveries();
        system.displaySummary();
    }
}
