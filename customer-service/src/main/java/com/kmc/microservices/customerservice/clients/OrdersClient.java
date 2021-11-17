package com.kmc.microservices.customerservice.clients;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmc.microservices.customerservice.dto.OrderDto;

@FeignClient(value = "order-service", fallback = OrdersClientFallback.class)
public interface OrdersClient {

	@CachePut(cacheNames = "customer-orders", key = "#customerId")
	@RequestMapping(value = "/{customerId}")
	List<OrderDto> getOrders(@PathVariable("customerId") Long customerId);
}
