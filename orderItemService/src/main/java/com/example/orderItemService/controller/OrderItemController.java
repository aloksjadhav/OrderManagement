package com.example.orderItemService.controller;

import com.example.orderItemService.service.OrderItemServiceImpl;
import com.example.orderItemService.vo.OrderItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @PostMapping(value = "/createOrderItem")
    public ResponseEntity<OrderItemVO> createOrderItem(@Valid @RequestBody OrderItemVO orderItemVO) {
        orderItemVO =  orderItemService.createOrderItem(orderItemVO);
        return new ResponseEntity(orderItemVO, HttpStatus.CREATED);

    }

    @GetMapping(value = "/retrieveOrderItem/{orderItemId}")
    public OrderItemVO retrieveOrderItem(@PathVariable(value="orderItemId") Long orderItemId) {
        OrderItemVO orderItemVO =  orderItemService.retrieveOrderItem(orderItemId);
        return orderItemVO;
    }
}
