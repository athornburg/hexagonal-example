package com.cece.alex.pos.pos.hex.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/{orderId}/add")
    public void addItem(@PathVariable int orderId, @RequestBody Item item) {
        orderService.addItemToOrder(orderId, item);
    }

}
