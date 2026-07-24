import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Demo02_Exception_Testing {
    @Test
    void testWithdrawInsufficientFunds() {
        Demo02_BankAccount account = new Demo02_BankAccount("123", 100.0);


        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });


        assertEquals("Insufficient balance", ex.getMessage());
    }
    @Test
    void testWithdrawInsufficientFundsFail() {
        Demo02_BankAccount account = new Demo02_BankAccount("123", 100.0);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });

        assertEquals("Not enough balance", ex.getMessage());
    }

}


