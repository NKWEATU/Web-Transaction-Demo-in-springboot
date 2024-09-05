package net.javaguides.springboot_transaction_demo_kennedy.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboot_transaction_demo_kennedy.entity.Order;
import net.javaguides.springboot_transaction_demo_kennedy.entity.Payment;

@Setter
@Getter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
