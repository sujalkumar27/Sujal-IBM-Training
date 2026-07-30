package com.example.springbootmockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;





@ExtendWith(MockitoExtension.class)
public class BankServiceTest {

    @Test
    void testDeposit() {
        BankRepository mockRepo =
                Mockito.mock(BankRepository.class);
        BankAccount account =
                new BankAccount("123",500);
        when(mockRepo.findByAccountNumber("123"))
                .thenReturn(account);
        BankService service =
                new BankService(mockRepo);
        service.deposit("123",200);
        assertEquals(
                700,
                account.getBalance()
        );
        verify(mockRepo)
                .save(account);
    }

    @Test
    void testWithdrawSuccess() {
        BankRepository mockRepo =
                Mockito.mock(BankRepository.class);
        BankAccount account =
                new BankAccount("123",500);
        when(mockRepo.findByAccountNumber("123"))
                .thenReturn(account);

        BankService service =
                new BankService(mockRepo);
        service.withdraw("123",200);
        assertEquals(
                300,
                account.getBalance()
        );
         verify(mockRepo)
                .save(account);


    }
    @Test
    void testWithdrawInsufficientFunds() {
        BankRepository mockRepo =
                Mockito.mock(BankRepository.class);
        BankAccount account =
                new BankAccount("123",100);
        when(mockRepo.findByAccountNumber("123"))
                .thenReturn(account);
        BankService service =
                new BankService(mockRepo);
        Exception exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> service.withdraw("123",200)
                );
        assertEquals(
                "Insufficient funds",
                exception.getMessage()
        );
        verify(mockRepo, never())
                .save(account);
    }
}
