package shilkin.mishop.service;

import org.springframework.stereotype.Service;
import shilkin.mishop.model.Order;
import shilkin.mishop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order saveOrder(Order order) {
        return repository.save(order);
    }
}
