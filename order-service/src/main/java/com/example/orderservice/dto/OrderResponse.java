package com.example.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private List<OrderLineItemsDto> orderLineItemsListDto;
}
