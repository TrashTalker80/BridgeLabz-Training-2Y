import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Parcel implements Comparable<Parcel> {
    private String parcelId;
    private int priority;

    public Parcel(String parcelId, int priority) {
        this.parcelId = parcelId;
        this.priority = priority;
    }

    public String getParcelId() {
        return parcelId;
    }

    @Override
    public int compareTo(Parcel other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return parcelId + " (Priority: " + priority + ")";
    }
}

public class CourierDeliveryRouting {
    private PriorityQueue<Parcel> priorityQueue;
    private Set<String> assignedIds;
    private List<Parcel> completedDeliveries;
    private Queue<Parcel> normalQueue;

    public CourierDeliveryRouting() {
        priorityQueue = new PriorityQueue<>();
        assignedIds = new HashSet<>();
        completedDeliveries = new ArrayList<>();
        normalQueue = new LinkedList<>();
    }

    public void addParcel(Parcel parcel) {
        if (assignedIds.add(parcel.getParcelId())) {
            priorityQueue.add(parcel);
            normalQueue.add(parcel);
            System.out.println("Parcel added: " + parcel);
        } else {
            System.out.println("Duplicate delivery ID: " + parcel.getParcelId());
        }
    }

    public void assignDeliveries() {
        System.out.println("\nAssigning deliveries by priority:");
        while (!priorityQueue.isEmpty()) {
            Parcel parcel = priorityQueue.poll();
            completedDeliveries.add(parcel);
            System.out.println("Assigned: " + parcel);
        }
    }

    public void displayCompleted() {
        System.out.println("\nCompleted deliveries: " + completedDeliveries.size());
    }

    public static void main(String[] args) {
        CourierDeliveryRouting system = new CourierDeliveryRouting();

        system.addParcel(new Parcel("PAR001", 3));
        system.addParcel(new Parcel("PAR002", 5));
        system.addParcel(new Parcel("PAR003", 1));
        system.addParcel(new Parcel("PAR001", 3));

        system.assignDeliveries();
        system.displayCompleted();
    }
}
