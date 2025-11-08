import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Booking implements Comparable<Booking> {
    private String bookingId;
    private String userId;
    private boolean isVIP;

    public Booking(String bookingId, String userId, boolean isVIP) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.isVIP = isVIP;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public int compareTo(Booking other) {
        return Boolean.compare(other.isVIP, this.isVIP);
    }

    @Override
    public String toString() {
        return bookingId + " - " + userId + (isVIP ? " [VIP]" : "");
    }
}

public class EventTicketReservation {
    private List<Booking> allBookings;
    private Set<String> uniqueUsers;
    private Queue<Booking> bookingQueue;
    private PriorityQueue<Booking> priorityQueue;

    public EventTicketReservation() {
        allBookings = new ArrayList<>();
        uniqueUsers = new HashSet<>();
        bookingQueue = new LinkedList<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void registerUser(String userId) {
        if (uniqueUsers.add(userId)) {
            System.out.println("User registered: " + userId);
        } else {
            System.out.println("User already registered: " + userId);
        }
    }

    public void acceptBooking(Booking booking) {
        if (uniqueUsers.contains(booking.getUserId())) {
            bookingQueue.add(booking);
            priorityQueue.add(booking);
            System.out.println("Booking accepted: " + booking);
        } else {
            System.out.println("User not registered: " + booking.getUserId());
        }
    }

    public void confirmBookings() {
        System.out.println("\nConfirming bookings (VIP priority):");
        while (!priorityQueue.isEmpty()) {
            Booking booking = priorityQueue.poll();
            allBookings.add(booking);
            System.out.println("Confirmed: " + booking);
        }
    }

    public static void main(String[] args) {
        EventTicketReservation system = new EventTicketReservation();

        system.registerUser("U001");
        system.registerUser("U002");
        system.registerUser("U001");

        system.acceptBooking(new Booking("B001", "U001", false));
        system.acceptBooking(new Booking("B002", "U002", true));
        system.acceptBooking(new Booking("B003", "U003", false));

        system.confirmBookings();
    }
}
