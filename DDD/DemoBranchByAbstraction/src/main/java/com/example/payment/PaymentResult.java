package com.example.payment;

public class PaymentResult {
    private final boolean success;
    private final String transactionId;
    private final String provider;

    public PaymentResult(boolean success, String transactionId, String provider) {
        this.success = success;
        this.transactionId = transactionId;
        this.provider = provider;
    }

    public boolean isSuccess()      { return success; }
    public String getTransactionId(){ return transactionId; }
    public String getProvider()     { return provider; }

    @Override
    public String toString() {
        return "PaymentResult{success=" + success +
               ", txId=" + transactionId +
               ", provider=" + provider + "}";
    }
}
