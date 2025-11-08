import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Account {
    private String accountId;

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return accountId;
    }
}

class Transaction {
    private String transactionId;
    private String accountId;
    private double amount;

    public Transaction(String transactionId, String accountId, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return transactionId + " - " + accountId + " ($" + amount + ")";
    }
}

public class BankingTransactionSystem {
    private List<Transaction> allTransactions;
    private Queue<Transaction> pendingTransactions;
    private Set<Account> validAccounts;
    private Stack<Transaction> rollbackStack;

    public BankingTransactionSystem() {
        allTransactions = new ArrayList<>();
        pendingTransactions = new LinkedList<>();
        validAccounts = new HashSet<>();
        rollbackStack = new Stack<>();
    }

    public void addValidAccount(Account account) {
        validAccounts.add(account);
        System.out.println("Account registered: " + account);
    }

    public void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
        System.out.println("Transaction queued: " + transaction);
    }

    public void executeTransactions() {
        System.out.println("\nExecuting transactions:");
        while (!pendingTransactions.isEmpty()) {
            Transaction transaction = pendingTransactions.poll();
            boolean isValid = validAccounts.stream()
                .anyMatch(acc -> acc.getAccountId().equals(transaction.getAccountId()));
            if (isValid) {
                allTransactions.add(transaction);
                rollbackStack.push(transaction);
                System.out.println("SUCCESS: " + transaction);
            } else {
                System.out.println("FAILED (Invalid account): " + transaction);
            }
        }
    }

    public void rollback() {
        if (!rollbackStack.isEmpty()) {
            Transaction last = rollbackStack.pop();
            System.out.println("\nRolled back: " + last);
        }
    }

    public static void main(String[] args) {
        BankingTransactionSystem system = new BankingTransactionSystem();

        system.addValidAccount(new Account("ACC001"));
        system.addValidAccount(new Account("ACC002"));

        system.addTransaction(new Transaction("TXN001", "ACC001", 1000));
        system.addTransaction(new Transaction("TXN002", "ACC002", 2000));
        system.addTransaction(new Transaction("TXN003", "ACC999", 500));

        system.executeTransactions();
        system.rollback();
    }
}
