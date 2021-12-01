package com.kmc.microservices.customerservice.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

import com.kmc.microservices.customerservice.dto.OrderDto;

@Component
public class OrdersClientFallback implements OrdersClient {

	@Autowired
	private RedisCacheManager cacheManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDto> getOrders(Long customerId) {
		return (List<OrderDto>) cacheManager.getCache("customer-orders").get(customerId).get();
	}

}
