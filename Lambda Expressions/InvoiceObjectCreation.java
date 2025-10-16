import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;
    private double amount;
    private LocalDate date;
    
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
        this.amount = Math.random() * 1000 + 100;
        this.date = LocalDate.now();
    }
    
    public Invoice(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = LocalDate.now();
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    @Override
    public String toString() {
        return String.format("Invoice[Transaction ID: %s, Amount: $%.2f, Date: %s]",
                           transactionId, amount, date);
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN001",
            "TXN002",
            "TXN003",
            "TXN004",
            "TXN005"
        );
        
        System.out.println("Invoice Generation System");
        System.out.println("==========================\n");
        
        System.out.println("Transaction IDs:");
        transactionIds.forEach(System.out::println);
        
        System.out.println("\nMethod 1: Using Constructor Reference (Invoice::new)");
        Function<String, Invoice> invoiceCreator = Invoice::new;
        List<Invoice> invoices = transactionIds.stream()
                                               .map(invoiceCreator)
                                               .collect(Collectors.toList());
        invoices.forEach(System.out::println);
        
        System.out.println("\nMethod 2: Direct Stream with Constructor Reference");
        List<Invoice> invoicesDirect = transactionIds.stream()
                                                     .map(Invoice::new)
                                                     .collect(Collectors.toList());
        invoicesDirect.forEach(System.out::println);
        
        System.out.println("\nInvoice Summary:");
        double totalAmount = invoices.stream()
                                     .mapToDouble(Invoice::getAmount)
                                     .sum();
        System.out.printf("Total Invoices: %d%n", invoices.size());
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
        System.out.printf("Average Amount: $%.2f%n", totalAmount / invoices.size());
    }
}
