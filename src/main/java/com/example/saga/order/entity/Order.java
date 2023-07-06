package com.example.saga.order.entity;


import java.util.Random;

public class Order {

    public enum OrderStatusEnum {
        PAYMENT_PENDING,
        PAYMENT_DECLINED,
        PAYMENT_ACCEPTED
    }

    public long id;

    public String customerName;
    public OrderStatusEnum status;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", status=" + status +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Order(String customerName, OrderStatusEnum status) {
        this.id = Math.abs(new Random().nextLong());
        this.customerName = customerName;
        this.status = status;
    }

    public void updatePaymentStatus(Payment.StatusEnum status) {
        if (status == Payment.StatusEnum.ACCEPTED) {
            this.status = OrderStatusEnum.PAYMENT_ACCEPTED;
        } else {
            this.status = OrderStatusEnum.PAYMENT_DECLINED;
        }
    }

}
