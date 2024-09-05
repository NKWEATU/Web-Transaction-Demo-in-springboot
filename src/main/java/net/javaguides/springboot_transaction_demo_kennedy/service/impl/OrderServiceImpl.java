package net.javaguides.springboot_transaction_demo_kennedy.service.impl;

import net.javaguides.springboot_transaction_demo_kennedy.dto.OrderRequest;
import net.javaguides.springboot_transaction_demo_kennedy.dto.OrderResponse;
import net.javaguides.springboot_transaction_demo_kennedy.entity.Order;
import net.javaguides.springboot_transaction_demo_kennedy.entity.Payment;
import net.javaguides.springboot_transaction_demo_kennedy.exception.PaymentException;
import net.javaguides.springboot_transaction_demo_kennedy.repository.OrderRepository;
import net.javaguides.springboot_transaction_demo_kennedy.repository.PaymentRepository;
import net.javaguides.springboot_transaction_demo_kennedy.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }



    @Override
   @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("In Progress...");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support this type of payment");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
