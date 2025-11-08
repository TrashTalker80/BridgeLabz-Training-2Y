import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Order {
    private String orderId;
    private String customerName;
    private double amount;

    public Order(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return orderId + " - " + customerName + " ($" + amount + ")";
    }
}

public class ECommerceOrderProcessing {
    private List<Order> allOrders;
    private Set<Order> uniqueOrders;
    private Queue<Order> orderQueue;
    private Stack<Order> failedOrders;

    public ECommerceOrderProcessing() {
        allOrders = new ArrayList<>();
        uniqueOrders = new HashSet<>();
        orderQueue = new LinkedList<>();
        failedOrders = new Stack<>();
    }

    public void addOrder(Order order) {
        allOrders.add(order);
        System.out.println("Added order: " + order);
    }

    public void removeDuplicates() {
        uniqueOrders.clear();
        uniqueOrders.addAll(allOrders);
        System.out.println("\nRemoved duplicates. Unique orders: " + uniqueOrders.size());
    }

    public void prepareForProcessing() {
        orderQueue.clear();
        orderQueue.addAll(uniqueOrders);
        System.out.println("Orders queued for processing: " + orderQueue.size());
    }

    public void processOrders() {
        System.out.println("\nProcessing orders:");
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            if (Math.random() > 0.8) {
                System.out.println("FAILED: " + order);
                failedOrders.push(order);
            } else {
                System.out.println("SUCCESS: " + order);
            }
        }
    }

    public void retryFailedOrders() {
        System.out.println("\nRetrying failed orders:");
        while (!failedOrders.isEmpty()) {
            Order order = failedOrders.pop();
            System.out.println("Retrying: " + order);
        }
    }

    public static void main(String[] args) {
        ECommerceOrderProcessing system = new ECommerceOrderProcessing();

        system.addOrder(new Order("ORD001", "John", 100));
        system.addOrder(new Order("ORD002", "Jane", 200));
        system.addOrder(new Order("ORD001", "John Duplicate", 100));
        system.addOrder(new Order("ORD003", "Bob", 150));

        system.removeDuplicates();
        system.prepareForProcessing();
        system.processOrders();
        system.retryFailedOrders();
    }
}
