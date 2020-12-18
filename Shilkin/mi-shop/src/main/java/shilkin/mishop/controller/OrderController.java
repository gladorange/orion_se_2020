package shilkin.mishop.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shilkin.mishop.dto.OrderDTO;
import shilkin.mishop.mapper.OrderMapper;
import shilkin.mishop.service.OrderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public OrderDTO saveOrder(@RequestBody @Valid OrderDTO orderDTO) {
        return orderMapper.toOrderDTO(orderService.saveOrder(orderMapper.toOrder(orderDTO)));
    }
}
