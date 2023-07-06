package com.example.saga.payment;

import com.example.saga.payment.entity.Payment;
import com.example.saga.payment.events.OrderCreatedEvent;
import com.example.saga.payment.events.PaymentProcessedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PaymentService {

    public static List<Payment> payments = new ArrayList<>();

    private PaymentProcessedProducer paymentProcessedProducer;

    @Autowired
    public PaymentService(PaymentProcessedProducer paymentProcessedProducer) {
        this.paymentProcessedProducer = paymentProcessedProducer;
    }

    public void processOrderCreated(OrderCreatedEvent event) {
        Payment payment = new Payment(event.orderId);

        if (getRandomIntegerBetweenRange(0, 100) < 50) {
            payment.accept("Payment accepted");
        } else {
            payment.decline("Payment declined");
        }

        payments.add(payment);

        PaymentProcessedEvent paymentProcessedEvent = PaymentProcessedEvent.fromPayment(payment);
        this.paymentProcessedProducer.sendPaymentProcessedMessage(paymentProcessedEvent);
    }

    public Integer getRandomIntegerBetweenRange(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }
}
