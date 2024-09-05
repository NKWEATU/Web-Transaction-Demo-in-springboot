package net.javaguides.springboot_transaction_demo_kennedy.service;

import net.javaguides.springboot_transaction_demo_kennedy.dto.OrderRequest;
import net.javaguides.springboot_transaction_demo_kennedy.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
