package com.kmc.microservices.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmc.microservices.orderservice.projections.OrderDto;
import com.kmc.microservices.orderservice.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{customerId}")
	public List<OrderDto> getAllOrders(@PathVariable Long customerId) {
		return orderService.findByCustomerId(customerId);
	}

	@PostMapping("/{customerId}")
	public OrderDto addOrderForCustomer(@PathVariable Long customerId, @RequestBody OrderDto order) {
		log.info("Saving new customer [{}]", order);
		return orderService.save(order);
	}
}
