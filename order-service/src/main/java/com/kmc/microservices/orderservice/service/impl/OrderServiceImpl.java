package com.kmc.microservices.orderservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kmc.microservices.orderservice.domain.Order;
import com.kmc.microservices.orderservice.projections.OrderDto;
import com.kmc.microservices.orderservice.repository.OrderRepository;
import com.kmc.microservices.orderservice.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@CacheEvict(cacheNames = { "orders" }, allEntries = true)
	@Override
	public OrderDto save(OrderDto order) {
		Order orderToSave = Optional.of(order)
			.map(Order::convertToEntity)
			.orElse(null);
		return Optional.of(orderRepository.save(orderToSave))
				.map(Order::convertToDto)
				.get();
	}

	@Cacheable("orders")
	@Override
	public List<OrderDto> findByCustomerId(Long customerId) {
		return orderRepository.findByCustomerId(customerId)
				.stream()
				.map(Order::convertToDto)
				.collect(Collectors.toList());
	}
}
