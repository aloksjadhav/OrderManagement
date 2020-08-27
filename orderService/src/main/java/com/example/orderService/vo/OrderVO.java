package com.example.orderService.vo;

import org.aspectj.weaver.ast.Or;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderVO {
    private Long orderId;
    @NotNull
    private String customerName;
    private Date orderDate;
    @NotNull
    private String shippingAddress;
    @NotNull
    private Long total;
    @NotNull
    private OrderItemVO orderItem;

    public OrderVO(){

    }

    public OrderVO(Long orderId, String customerName, Date orderDate, String shippingAddress, Long total) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public OrderItemVO getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemVO orderItem) {
        this.orderItem = orderItem;
    }
}
