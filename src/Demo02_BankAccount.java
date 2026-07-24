public class Demo02_BankAccount {

    private String accountNumber;
    private double balance;


    public Demo02_BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}
