package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.model.OrderLineItems;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderLineItemsMapper {
    public OrderLineItems mapFromDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        BeanUtils.copyProperties(orderLineItemsDto, orderLineItems);
        return orderLineItems;
    }

    public OrderLineItemsDto mapToDto(OrderLineItems orderLineItems) {
        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
        BeanUtils.copyProperties(orderLineItems, orderLineItemsDto);
        return orderLineItemsDto;
    }
}
