package shilkin.mishop.mapper;

import org.springframework.stereotype.Component;
import shilkin.mishop.dto.OrderDTO;
import shilkin.mishop.model.Order;
import shilkin.mishop.model.Product;

@Component
public class OrderMapper {
    public OrderDTO toOrderDTO(Order order) {
        if (order == null) {
            return null;
        }
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        if (order.getProduct() != null) {
            dto.setProductId(order.getProduct().getId());
        }
        dto.setProductCount(order.getProductCount());
        dto.setFinalPrice(order.getFinalPrice());
        return dto;
    }

    public Order toOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDTO.getId());
        if (orderDTO.getProductId() != null) {
            Product product = new Product();
            product.setId(orderDTO.getProductId());
            order.setProduct(product);
        }
        order.setProductCount(orderDTO.getProductCount());
        order.setFinalPrice(orderDTO.getFinalPrice());
        return order;
    }
}
