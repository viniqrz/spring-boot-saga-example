package com.example.saga.order.events;

import com.example.saga.order.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

public class OrderCreatedEvent {
    public long eventId;
    public String customerName;

    public long orderId;

     public static OrderCreatedEvent fromOrder(Order order) {
         OrderCreatedEvent event = new OrderCreatedEvent();
         event.eventId = Math.abs(new Random().nextInt());
         event.customerName = order.getCustomerName();
         event.orderId = order.getId();
         return event;
    }

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "eventId=" + eventId +
                ", customerName='" + customerName + '\'' +
                '}';
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
