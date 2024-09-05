package net.javaguides.springboot_transaction_demo_kennedy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

    private String orderTrackingNumber;
    private String status;
    private String message;

}
