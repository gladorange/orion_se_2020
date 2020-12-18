package shilkin.mishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shilkin.mishop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
