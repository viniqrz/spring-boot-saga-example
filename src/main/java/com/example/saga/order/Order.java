package com.example.saga.order;

enum OrderStatusEnum {
    PAYMENT_PENDING,
    PAYMENT_DECLINED,
    PAYMENT_ACCEPTED
}

public class Order {
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

    public Order(long id, String customerName, OrderStatusEnum status) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
    }


}
