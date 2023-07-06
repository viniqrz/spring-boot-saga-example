package com.example.saga.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service()
public class OrderService {

    public static List<Order> orders = new ArrayList<Order>();

    private OrderCreatedProducer orderCreatedProducer;

    @Autowired
    public OrderService(OrderCreatedProducer orderCreatedProducer) {
        this.orderCreatedProducer = orderCreatedProducer;
    }

    public List<Order> getOrders() {
        return OrderService.orders;
    }

    public void createOrder() {
        Order order = new Order(Math.abs(new Random().nextLong()), "Mohammed Bilal", OrderStatusEnum.PAYMENT_PENDING);
        OrderService.orders.add(order);
        OrderCreatedEvent orderEvent = OrderCreatedEvent.fromOrder(order);
        this.orderCreatedProducer.sendOrderCreatedMessage(orderEvent);
    }
}
