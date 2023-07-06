package com.example.saga.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderCreatedConsumer {

    static final String TOPIC = "ORDER_CREATED_TOPIC";

    private PaymentService paymentService;

    @Autowired
    public OrderCreatedConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = TOPIC)
    public void consume(@Payload String message, Acknowledgment ack) {
        OrderCreatedEvent event = OrderCreatedEvent.fromJSON(message);
        this.paymentService.processOrderCreated(event);
        ack.acknowledge();
    }
}
