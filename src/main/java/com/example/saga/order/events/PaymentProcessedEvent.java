package com.example.saga.order.events;


import com.example.saga.order.entity.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentProcessedEvent {
    public long eventId;
    public long orderId;
    public Payment.StatusEnum status;

    public PaymentProcessedEvent() {}

    public PaymentProcessedEvent(long orderId, Payment.StatusEnum status) {
        this.eventId = System.currentTimeMillis();
        this.orderId = orderId;
        this.status = status;
    }

    public static PaymentProcessedEvent fromPayment(Payment payment) {
        return new PaymentProcessedEvent(payment.orderId, payment.status);
    }

    public String toJSON() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static PaymentProcessedEvent fromJSON(String json) {
        try {
            ObjectMapper objectMapper = new JsonMapper();
            PaymentProcessedEvent event = objectMapper.readValue(json, PaymentProcessedEvent.class);
            return event;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "PaymentProcessedEvent{" +
                "eventId=" + eventId +
                ", orderId=" + orderId +
                ", status=" + status +
                '}';
    }
}
