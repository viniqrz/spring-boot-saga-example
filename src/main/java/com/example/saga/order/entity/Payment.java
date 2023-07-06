package com.example.saga.order.entity;



public class Payment {

    public enum StatusEnum {
        DECLINED,
        ACCEPTED
    }
    public long orderId;
    public StatusEnum status;
    public String reason;

    public Payment(long orderId, StatusEnum status, String reason) {
        this.orderId = orderId;
        this.status = status;
        this.reason = reason;
    }

    public Payment(long orderId) {
        this.orderId = orderId;
    }

    public void accept(String reason) {
        this.status = StatusEnum.ACCEPTED;
        this.reason = reason;
    }

    public void decline(String reason) {
        this.status = StatusEnum.DECLINED;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }
}
