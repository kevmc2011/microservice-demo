package com.kmc.microservices.orderservice.projections;

import java.util.List;

public interface OrderDto {
	Long getCustomerId();
	List<ProductDto> getProducts();
}
