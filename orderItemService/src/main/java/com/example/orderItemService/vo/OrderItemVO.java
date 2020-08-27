package com.example.orderItemService.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderItemVO {
    private Long orderItemId;
    @NotNull
    private String productCode;
    @NotNull
    private String productName;
    private int quantity;


    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
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
