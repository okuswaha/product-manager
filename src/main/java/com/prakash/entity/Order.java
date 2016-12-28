package com.prakash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;


/**
 * Created by okuswaha on 12/23/2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable{
    @Id
    @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "PAID")
    private boolean paid;
    @Column(name = "PAID_DATE")
    private Date paidDate;

    public Order() {
    }

    public Order(int orderId, int customerId, Date orderDate, boolean paid, Date paidDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.paid = paid;
        this.paidDate = paidDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", paid=" + paid +
                ", paidDate=" + paidDate +
                '}';
    }
}
