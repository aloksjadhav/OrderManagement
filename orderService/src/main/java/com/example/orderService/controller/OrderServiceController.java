package com.example.orderService.controller;

import com.example.orderService.exception.ValidationException;
import com.example.orderService.service.OrderServiceImpl;
import com.example.orderService.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class OrderServiceController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(value = "/createOrder")
    public ResponseEntity createOrder(@Valid @RequestBody OrderVO inputVO) {
        OrderVO orderVo =  orderService.createOrder(inputVO);
        return new ResponseEntity<Object>(orderVo, HttpStatus.CREATED);
    }

    @GetMapping(value = "/retrieveOrder")
    public List<OrderVO> retrieveOrder() {
        List<OrderVO> outputResponse = orderService.retrieveOrders();
        return outputResponse;
    }

    @GetMapping(value = "/retrieveOrder/{id}")
    public OrderVO retrieveOrder(@PathVariable long id) {
        OrderVO outputResponse = orderService.retrieveOrder(id);
        return outputResponse;
    }
}
