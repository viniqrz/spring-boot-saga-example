package com.example.saga.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.util.Random;

public class OrderCreatedEvent {
    public long eventId;
    public String customerName;

     public static OrderCreatedEvent fromOrder(Order order) {
         OrderCreatedEvent event = new OrderCreatedEvent();
         event.eventId = Math.abs(new Random().nextInt());
         event.customerName = order.getCustomerName();
         return event;
    }

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "eventId=" + eventId +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public String toJSON() {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(this);
            return json;
        } catch(Exception e) {
            return "";
        }
    }
}
