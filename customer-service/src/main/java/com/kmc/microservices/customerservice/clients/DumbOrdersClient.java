package com.kmc.microservices.customerservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmc.microservices.customerservice.dto.OrderDto;

@FeignClient(contextId = "dumbOrdersClient", value = "order-service")
public interface DumbOrdersClient {

	@RequestMapping(value = "/{customerId}")
	List<OrderDto> getOrders(@PathVariable("customerId") Long customerId);
}
