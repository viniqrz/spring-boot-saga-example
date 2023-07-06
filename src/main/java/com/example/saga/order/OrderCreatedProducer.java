package com.example.saga.order;

import com.example.saga.shared.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderCreatedProducer {
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "ORDER_CREATED_TOPIC";

    @Autowired
    public OrderCreatedProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedMessage(OrderCreatedEvent event) {
        this.kafkaTemplate.send(TOPIC, event.toJSON());
    }
}
