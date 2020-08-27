package com.example.orderItemService.dao;

import com.example.orderItemService.entity.OrderItemEntity;
import com.example.orderItemService.exception.DAOException;
import com.example.orderItemService.exception.OrderItemNotFoundException;
import com.example.orderItemService.vo.OrderItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderItemDAO {

    @Autowired
    private OrderItemRepository repo;

    public OrderItemEntity createOrderItem(OrderItemEntity orderItemE) {

        OrderItemEntity orderItemEntity = null;
        try {
             orderItemEntity =  repo.save(orderItemE);
        } catch (Exception ex) {
            throw new DAOException("Error in saving data");
        }
        return orderItemEntity;
    }

    public OrderItemEntity retrieveOrderItem(Long orderItemId) {
        Optional<OrderItemEntity> oe =   repo.findById(orderItemId);
        if(oe.isPresent()){
            return oe.get();
        } else {
            throw new OrderItemNotFoundException("OrderItemNotFound");
        }
    }
}
