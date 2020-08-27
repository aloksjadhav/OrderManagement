package com.example.orderItemService.service;

import com.example.orderItemService.dao.OrderItemDAO;
import com.example.orderItemService.entity.OrderItemEntity;
import com.example.orderItemService.vo.OrderItemVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl {

    @Autowired
    private OrderItemDAO orderItemDAO;

    @Autowired
    private DozerBeanMapper mapper;

    public OrderItemVO createOrderItem( OrderItemVO orderItemVO) {
        OrderItemEntity oe = mapper.map(orderItemVO, OrderItemEntity.class);
        oe =  orderItemDAO.createOrderItem(oe);
        orderItemVO.setOrderItemId(oe.getOrderItemId());
        return orderItemVO;
    }

    public OrderItemVO retrieveOrderItem( Long orderItemId) {
       OrderItemEntity oe = orderItemDAO.retrieveOrderItem(orderItemId);
        OrderItemVO orderItemVO = mapper.map(oe, OrderItemVO.class);
        return orderItemVO;
    }
}
