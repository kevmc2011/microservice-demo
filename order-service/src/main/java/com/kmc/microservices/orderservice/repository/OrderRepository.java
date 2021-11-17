package com.kmc.microservices.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmc.microservices.orderservice.domain.Order;
import com.kmc.microservices.orderservice.projections.OrderDto;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<OrderDto> findByCustomerId(Long customerId);
}
