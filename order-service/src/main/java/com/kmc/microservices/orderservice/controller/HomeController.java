package com.kmc.microservices.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmc.microservices.orderservice.domain.Order;
import com.kmc.microservices.orderservice.projections.OrderDto;
import com.kmc.microservices.orderservice.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{customerId}")
	public List<OrderDto> getAllOrders(@PathVariable Long customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	@PostMapping("/{customerId}")
	public Order addOrderForCustomer(@PathVariable Long customerId, @RequestBody Order order) {
		log.info("Saving new customer [{}]", order);
		return orderRepository.save(order);
	}
}
