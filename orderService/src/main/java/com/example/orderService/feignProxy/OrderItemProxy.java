package com.example.orderService.feignProxy;

import com.example.orderService.vo.OrderItemVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Service
@FeignClient(name="orderItem", url="${orderItem_url}")
public interface OrderItemProxy {

    @PostMapping(value = "/createOrderItem")
    public ResponseEntity<OrderItemVO> createOrderItem(@Valid @RequestBody OrderItemVO orderItemVO) ;

    @RequestMapping(value = "/retrieveOrderItem/{orderItemId}", method = RequestMethod.GET)
    public OrderItemVO retrieveOrderItem(@PathVariable(value="orderItemId") Long orderItemId) ;

}
