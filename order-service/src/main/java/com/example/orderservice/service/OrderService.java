package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.mapper.OrderLineItemsMapper;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderLineItemsMapper orderLineItemsMapper;
    private final OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsListDto()
                .stream()
                .map(orderLineItemsMapper::mapFromDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderLineItemsListDto(order.getOrderLineItemsList()
                .stream()
                .map(orderLineItemsMapper::mapToDto)
                .toList());

        return orderResponse;
    }
}
