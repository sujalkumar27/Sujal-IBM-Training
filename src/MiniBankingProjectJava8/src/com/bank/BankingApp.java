package com.bank;

import com.bank.PaymentProcessor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BankingApp {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE CUSTOMERS
        // =====================================================

        Customer customer1 =
                new Customer(
                        "Sujal",
                        "ABCDE1234F"
                );

        Customer customer2 =
                new Customer(
                        "Ravi",
                        null
                );

        System.out.println("===== CUSTOMERS =====");

        System.out.println(customer1);
        System.out.println(customer2);


        // =====================================================
        // 2. OPTIONAL
        // =====================================================

        System.out.println("\n===== OPTIONAL =====");

        customer1.getPancard()
                .ifPresent(
                        pan -> System.out.println(
                                "Sujal PAN: " + pan
                        )
                );

        String raviPan =
                customer2.getPancard()
                        .orElse("PAN not available");

        System.out.println(
                "Ravi PAN: " + raviPan
        );


        // =====================================================
        // 3. CREATE BANK ACCOUNTS
        // =====================================================

        BankAccount account1 =
                new BankAccount(
                        101,
                        customer1
                );

        BankAccount account2 =
                new BankAccount(
                        102,
                        customer2
                );

        System.out.println("\n===== BANKING OPERATIONS =====");

        account1.deposit(5000);
        account1.withdraw(1000);

        account2.deposit(3000);


        System.out.println("\n===== ACCOUNT DETAILS =====");

        System.out.println(account1);
        System.out.println(account2);


        // =====================================================
        // 4. CREATE TRANSACTIONS
        // =====================================================

        List<Transaction> transactions =
                Arrays.asList(

                        new Transaction(
                                500,
                                LocalDate.now()
                        ),

                        new Transaction(
                                2500,
                                LocalDate.now()
                        ),

                        new Transaction(
                                1200,
                                LocalDate.now()
                        ),

                        new Transaction(
                                700,
                                LocalDate.now()
                        )
                );


        // =====================================================
        // 5. CREATE BANKING SERVICE
        // =====================================================

        BankingService bankingService =
                new BankingService();

        bankingService.addCustomer(customer1);
        bankingService.addCustomer(customer2);

        bankingService.addAccount(account1);
        bankingService.addAccount(account2);

        transactions.forEach(
                bankingService::addTransaction
        );


        // =====================================================
        // 6. forEach + METHOD REFERENCE
        // =====================================================

        System.out.println(
                "\n===== ALL TRANSACTIONS ====="
        );

        transactions.forEach(
                System.out::println
        );


        // =====================================================
        // 7. STREAM + FILTER + LAMBDA
        // =====================================================

        System.out.println(
                "\n===== HIGH VALUE TRANSACTIONS ====="
        );

        transactions.stream()
                .filter(
                        transaction ->
                                transaction.getAmount() > 1000
                )
                .forEach(
                        System.out::println
                );


        // =====================================================
        // 8. COLLECT
        // =====================================================

        System.out.println(
                "\n===== HIGH VALUE TRANSACTION LIST ====="
        );

        List<Transaction> highValueTransactions =
                bankingService
                        .getHighValueTransactions(1000);

        highValueTransactions.forEach(
                System.out::println
        );


        // =====================================================
        // 9. MAP
        // =====================================================

        System.out.println(
                "\n===== CUSTOMER NAMES ====="
        );

        bankingService
                .getCustomerNames()
                .forEach(
                        System.out::println
                );


        // =====================================================
        // 10. REDUCE
        // =====================================================

        System.out.println(
                "\n===== TOTAL TRANSACTION AMOUNT ====="
        );

        int total =
                bankingService
                        .getTotalTransactionAmount();

        System.out.println(
                "Total: ₹" + total
        );


        // =====================================================
        // 11. SORTED + COMPARATOR
        // =====================================================

        System.out.println(
                "\n===== SORTED TRANSACTIONS ====="
        );

        bankingService
                .getTransactionsSortedByAmount()
                .forEach(
                        System.out::println
                );


        // =====================================================
        // 12. PREDICATE
        // =====================================================

        System.out.println(
                "\n===== PREDICATE EXAMPLE ====="
        );

        bankingService
                .getHighValueTransactions(1500)
                .forEach(
                        System.out::println
                );


        // =====================================================
        // 13. CONSUMER
        // =====================================================

        System.out.println(
                "\n===== CONSUMER EXAMPLE ====="
        );

        Consumer<Customer> customerPrinter =
                customer ->
                        System.out.println(
                                "Customer: "
                                        + customer.getName()
                        );

        bankingService
                .getCustomers()
                .forEach(customerPrinter);


        // =====================================================
        // 14. FUNCTION
        // =====================================================

        System.out.println(
                "\n===== FUNCTION EXAMPLE ====="
        );

        Function<Transaction, Integer> amountFunction =
                Transaction::getAmount;

        int firstTransactionAmount =
                amountFunction.apply(
                        transactions.get(0)
                );

        System.out.println(
                "First transaction amount: ₹"
                        + firstTransactionAmount
        );


        // =====================================================
        // 15. SUPPLIER
        // =====================================================

        System.out.println(
                "\n===== SUPPLIER EXAMPLE ====="
        );

        Supplier<Integer> transactionIdGenerator =
                () ->
                        (int) (Math.random() * 10000);

        System.out.println(
                "Generated Transaction ID: "
                        + transactionIdGenerator.get()
        );


        // =====================================================
        // 16. FUNCTIONAL INTERFACE + LAMBDA
        // =====================================================

        System.out.println(
                "\n===== FUNCTIONAL INTERFACE ====="
        );

        PaymentProcessor processor =
                amount ->
                        System.out.println(
                                "Processing payment of ₹"
                                        + amount
                        );

        processor.process(5000);


        // =====================================================
        // 17. DEFAULT METHOD
        // =====================================================

        System.out.println(
                "\n===== DEFAULT METHOD ====="
        );

        CreditCardPayment payment =
                new CreditCardPayment();

        payment.validate();

        payment.pay(2500);


        // =====================================================
        // 18. STATIC INTERFACE METHOD
        // =====================================================

        System.out.println(
                "\n===== STATIC INTERFACE METHOD ====="
        );

        Payment.log(
                "Credit card payment processed successfully"
        );


        // =====================================================
        // 19. JAVA 8 DATE API
        // =====================================================

        System.out.println(
                "\n===== JAVA 8 DATE API ====="
        );

        LocalDate today =
                LocalDate.now();

        LocalDate nextEmi =
                today.plusMonths(1);

        System.out.println(
                "Today: " + today
        );

        System.out.println(
                "Next EMI Date: " + nextEmi
        );


        // =====================================================
        // END
        // =====================================================

        System.out.println(
                "\n===== BANKING APP COMPLETED ====="
        );
    }
}