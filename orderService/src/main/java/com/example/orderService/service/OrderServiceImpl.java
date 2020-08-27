package com.example.orderService.service;

import com.example.orderService.dao.OrderServiceDaoImpl;
import com.example.orderService.entity.OrderEntity;
import com.example.orderService.exception.OrderNotFoundException;
import com.example.orderService.exception.ValidationException;
import com.example.orderService.feignProxy.OrderItemProxy;
import com.example.orderService.vo.OrderItemVO;
import com.example.orderService.vo.OrderVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private OrderItemProxy orderItemProxy;

    @Autowired
    private OrderServiceDaoImpl orderDao;

    public OrderVO createOrder(OrderVO orderVO) {
        // API call using Feign client to store orderItem
        ResponseEntity<OrderItemVO> orderItemVO = (ResponseEntity) orderItemProxy.createOrderItem(orderVO.getOrderItem());
        OrderEntity orderEntity = mapper.map(orderVO, OrderEntity.class);
        orderEntity.setOrderDate(new Date(System.currentTimeMillis()));
        orderEntity.setOrderItemId(orderItemVO.getBody().getOrderItemId());
        // DB call to store order
        orderEntity = orderDao.createOrder(orderEntity);
        orderVO.setOrderId(orderEntity.getOrderId());
        orderVO.getOrderItem().setOrderItemId(orderItemVO.getBody().getOrderItemId());
        return orderVO;
    }

    public List<OrderVO> retrieveOrders() {
        List<OrderEntity> orderEntity = orderDao.retrieveOrders();
        List<OrderVO> orderList =
            orderEntity.stream().map(orderE -> new OrderVO(orderE.getOrderId(), orderE.getCustomerName(), orderE.getOrderDate(), orderE.getShippingAddress(), orderE.getTotal())).collect(Collectors.toList());
        //OrderVO order = mapper.map(orderEntity, OrderVO.class);
        return orderList;
    }

    public OrderVO retrieveOrder(Long orderId) {
        OrderEntity orderEntity = orderDao.retrieveOrder(orderId);
        if (orderEntity == null) {
            throw new OrderNotFoundException("Order not found in database");
        }
        OrderVO order = mapper.map(orderEntity, OrderVO.class);
        OrderItemVO orderItemVO = orderItemProxy.retrieveOrderItem(orderEntity.getOrderItemId());
        order.setOrderItem(orderItemVO);
        return order;
    }

}
