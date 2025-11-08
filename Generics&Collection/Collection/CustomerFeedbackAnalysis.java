import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CustomerFeedbackAnalysis {
    private List<String> allFeedback;
    private Set<String> uniqueFeedback;
    private Queue<String> processingQueue;
    private Stack<String> recentFeedback;

    public CustomerFeedbackAnalysis() {
        allFeedback = new ArrayList<>();
        uniqueFeedback = new HashSet<>();
        processingQueue = new LinkedList<>();
        recentFeedback = new Stack<>();
    }

    public void addFeedback(String feedback) {
        allFeedback.add(feedback);
        System.out.println("Feedback added: " + feedback);
    }

    public void removeDuplicates() {
        System.out.println("\nRemoving duplicates:");
        uniqueFeedback.clear();
        uniqueFeedback.addAll(allFeedback);
        processingQueue.clear();
        processingQueue.addAll(uniqueFeedback);
        System.out.println("Unique feedback count: " + uniqueFeedback.size());
    }

    public void processFeedback() {
        System.out.println("\nProcessing feedback:");
        while (!processingQueue.isEmpty()) {
            String feedback = processingQueue.poll();
            recentFeedback.push(feedback);
            System.out.println("Processed: " + feedback);
        }
    }

    public void displayRecentFeedback(int count) {
        System.out.println("\nRecent " + count + " feedbacks:");
        int displayed = 0;
        for (String feedback : recentFeedback) {
            if (displayed >= count) break;
            System.out.println(feedback);
            displayed++;
        }
    }

    public static void main(String[] args) {
        CustomerFeedbackAnalysis system = new CustomerFeedbackAnalysis();

        system.addFeedback("Great service!");
        system.addFeedback("Needs improvement");
        system.addFeedback("Great service!");
        system.addFeedback("Fast delivery");

        system.removeDuplicates();
        system.processFeedback();
        system.displayRecentFeedback(2);
    }
}
