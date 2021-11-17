package com.kmc.microservices.customerservice.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8031954900547590079L;
	private List<ProductDto> products;
}
