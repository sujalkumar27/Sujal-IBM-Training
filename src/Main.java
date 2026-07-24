
class BankAccount {
    void withdraw(double amount) {
        System.out.println("Bank Account: ₹" + amount + " from Bank Account");
    }
}
class SavingsAccount extends BankAccount {
    @Override
    void withdraw(double amount) {
        System.out.println("Saving Account: ₹" + amount);

    }
}
public class Main{
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();
        account.withdraw(10000);
    }
}