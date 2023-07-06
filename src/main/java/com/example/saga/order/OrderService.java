package com.example.saga.order;

import com.example.saga.shared.entity.Order;
import com.example.saga.shared.event.OrderCreatedEvent;
import com.example.saga.shared.event.PaymentProcessedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Order order = new Order("Mohammed Bilal", Order.OrderStatusEnum.PAYMENT_PENDING);
        OrderService.orders.add(order);
        OrderCreatedEvent orderEvent = OrderCreatedEvent.fromOrder(order);
        this.orderCreatedProducer.sendOrderCreatedMessage(orderEvent);
    }

    public Order findOrderById(Long orderId) {
        for (Order order : OrderService.orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public void processOrderPaymentUpdate(PaymentProcessedEvent event) {
        Order order = findOrderById(event.orderId);
        if (order == null) return;
        order.updatePaymentStatus(event.status);
    }
}
