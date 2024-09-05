package net.javaguides.springboot_transaction_demo_kennedy.repository;

import net.javaguides.springboot_transaction_demo_kennedy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
