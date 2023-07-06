package com.example.saga.order;

import com.example.saga.shared.event.PaymentProcessedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component()
@EnableKafka()
public class PaymentProcessedConsumer {

    static final String TOPIC = "PAYMENT_PROCESSED_TOPIC";

    private OrderService orderService;

    @Autowired
    public PaymentProcessedConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = TOPIC)
    public void consume(String message) {
        PaymentProcessedEvent event = PaymentProcessedEvent.fromJSON(message);
        this.orderService.processOrderPaymentUpdate(event);
    }
}
