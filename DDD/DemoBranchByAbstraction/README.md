# Task 20.3 — Branch by Abstraction

Introduce an abstraction (`PaymentProcessor`) so the old and new payment
implementations can coexist. A runtime switch decides which one runs.

```
             +----------------------+
Caller ----> |   PaymentProcessor   | (interface)
             +----------+-----------+
                        |
        +---------------+---------------+
        |                               |
+-------v---------+           +---------v---------+
|  LegacyPayment  |           |    NewPayment     |
|    Processor    |           |    Processor      |
+-----------------+           +-------------------+
```

## Files
- `PaymentProcessor.java`         — the abstraction
- `LegacyPaymentProcessor.java`   — old implementation
- `NewPaymentProcessor.java`      — new implementation
- `PaymentProcessorFactory.java`  — picks impl at runtime from `PAYMENT_IMPL`
- `Main.java`                     — demo

## How to switch
Set the system property or env var:
```
-Dpayment.impl=new     # or legacy
```
