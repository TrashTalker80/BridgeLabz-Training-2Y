public class ATMAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public ATMAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

class MainATMAccount {
    public static void main(String[] args) {
        ATMAccount account = new ATMAccount("Bob", "123456789", 10000.0);
        account.deposit(5000);
        account.withdraw(3000);
        account.displayBalance();
    }
}