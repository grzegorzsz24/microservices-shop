package com.example.orderservice.dto;

import java.math.BigDecimal;

public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
