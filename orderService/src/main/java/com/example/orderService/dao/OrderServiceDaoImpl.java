package com.example.orderService.dao;

import com.example.orderService.entity.OrderEntity;
import com.example.orderService.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderServiceDaoImpl {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity createOrder(OrderEntity orderE) {
        OrderEntity orderEntity =  orderRepository.save(orderE);
        return orderEntity;
    }

    public List<OrderEntity> retrieveOrders() {
        List<OrderEntity> orderList = orderRepository.findAll();
        return orderList;
    }

    public OrderEntity retrieveOrder(Long orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if (orderEntity.isPresent()) {
            return orderEntity.get();
        } else {
            return null;
        }
    }
}
