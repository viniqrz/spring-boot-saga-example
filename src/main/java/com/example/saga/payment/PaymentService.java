package com.example.saga.payment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PaymentService {

    public static List<Payment> payments = new ArrayList<>();

    public void processOrderCreated(OrderCreatedEvent event) {
        Payment payment = new Payment(event.orderId);

        if (getRandomIntegerBetweenRange(0, 100) < 50) {
            payment.accept("Payment accepted");
        } else {
            payment.decline("Payment declined");
        }

        payments.add(payment);

        System.out.println("Payment created: " + payment.toString());
        System.out.println("Processing order created event: " + event);
    }

    public Integer getRandomIntegerBetweenRange(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }
}
