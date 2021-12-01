package com.kmc.microservices.orderservice.service;

import java.util.List;

import com.kmc.microservices.orderservice.projections.OrderDto;

public interface OrderService {

	OrderDto save(OrderDto order);

	List<OrderDto> findByCustomerId(Long customerId);

}
