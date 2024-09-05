package net.javaguides.springboot_transaction_demo_kennedy.exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message) {
        super(message);
    }

}
