package com.example.orderService.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "CUSTOMER_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "TOTAL")
    private Long total;

    @Column(name = "ORDER_ITEM_ID")
    private Long orderItemId;

    public OrderEntity(){}

    public OrderEntity(long orderId, String customerName, Date orderDate, String shippingAddress, Long total) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
}
