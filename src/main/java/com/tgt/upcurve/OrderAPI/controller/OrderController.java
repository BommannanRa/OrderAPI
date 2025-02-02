package com.tgt.upcurve.OrderAPI.controller;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order_api/v1")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/fetch_order_by_id/{customer_id}/{order_id}")
    public Order fetchOrderByCustomerIdAndOrderId(@Validated @PathVariable("customer_id") Integer customerId, @Validated @PathVariable("order_id") Integer orderId) {
        return orderService.fetchOrderByCustomerIdAndOrderId(customerId, orderId);

    }

    @GetMapping("/fetch_order_by_customer_id/{customer_id}")
    public List<Order> fetchOrderByCustomerId(@Validated @PathVariable("customer_id") Integer customerId) {
        return orderService.fetchOrderByCustomerId(customerId);
    }

    @PostMapping
    public Order saveOrder(@Validated @RequestBody Order order) {
        return orderService.saveOrder(order);
    }


    @DeleteMapping("/{customer_id}/{order_id}")
    public void deleteOrder(@Validated @PathVariable("customer_id") Integer customerId, @Validated @PathVariable("order_id") Integer orderId) {
        orderService.deleteOrder(customerId, orderId);
    }



}
