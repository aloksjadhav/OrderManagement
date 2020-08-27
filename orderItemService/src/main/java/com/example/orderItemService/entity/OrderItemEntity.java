package com.example.orderItemService.entity;

import javax.persistence.*;

@Entity
@Table(name="ORDER_ITEM")
public class OrderItemEntity {

    @Id
    @GeneratedValue
    private long orderItemId;
    @Column(name="PRODUCT_CODE")
    private String productCode;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="QUANTITY")
    private int quantity;

    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
