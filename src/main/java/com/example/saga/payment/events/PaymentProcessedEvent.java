package com.example.saga.payment.events;


import com.example.saga.payment.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentProcessedEvent {
    public long eventId;
    public long orderId;
    public Payment.StatusEnum status;

    public PaymentProcessedEvent(long orderId, Payment.StatusEnum status) {
        this.eventId = System.currentTimeMillis();
        this.orderId = orderId;
        this.status = status;
    }

    public static PaymentProcessedEvent fromPayment(Payment payment) {
        return new PaymentProcessedEvent(payment.orderId, payment.status);
    }

    public String toJSON() {
        return "{" +
                "\"eventId\":" + eventId +
                ", \"orderId\":" + orderId +
                ", \"status\":\"" + status + "\"" +
                "}";
    }

    public static PaymentProcessedEvent fromJSON(String json) {
        try {
            ObjectMapper objectMapper = new JsonMapper();
            PaymentProcessedEvent event = objectMapper.readValue(json, PaymentProcessedEvent.class);
            return event;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "JSON Parsing Exception");
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
