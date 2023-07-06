package com.example.saga.payment;

import com.example.saga.shared.event.PaymentProcessedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessedProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "PAYMENT_PROCESSED_TOPIC";

    @Autowired
    public PaymentProcessedProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentProcessedMessage(PaymentProcessedEvent event) {
        this.kafkaTemplate.send(TOPIC, event.toJSON());
    }
}
