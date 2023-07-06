package com.example.saga.payment.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderCreatedEvent {
    public long eventId;
    public String customerName;

    public long orderId;

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "eventId=" + eventId +
                ", customerName='" + customerName + '\'' +
                 ", orderId='" + orderId + '\'' +
                '}';
    }

    static public OrderCreatedEvent fromJSON(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            OrderCreatedEvent event = objectMapper.readValue(json, OrderCreatedEvent.class);
            return event;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "JSON Parsing Exception");
        }
    }

    public String toJSON()  {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(this);
            return json;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "JSON Parsing Exception");
        }
    }
}