package net.javaguides.springboot_transaction_demo_kennedy.repository;

import net.javaguides.springboot_transaction_demo_kennedy.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
