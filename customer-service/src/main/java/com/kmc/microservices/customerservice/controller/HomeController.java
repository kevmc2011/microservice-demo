package com.kmc.microservices.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmc.microservices.customerservice.clients.OrdersClient;
import com.kmc.microservices.customerservice.domain.Customer;
import com.kmc.microservices.customerservice.dto.CustomerDto;
import com.kmc.microservices.customerservice.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrdersClient ordersClient;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/{customerId}")
	public CustomerDto getCustomerDetails(@PathVariable Long customerId) {
		return customerRepository
			.findById(customerId)
			.map(this::convertToDto)
			.orElse(new CustomerDto());
	}

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		log.info("Saving new customer [{}]", customer);
		return customerRepository.save(customer);
	}

	private CustomerDto convertToDto(Customer customer) {
		return CustomerDto.builder()
				.name(customer.getName())
				.orders(ordersClient.getOrders(customer.getId()))
				.build();
	}
}
