package com.kmc.microservices.orderservice.projections;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2215441746458353261L;
	private String sku;
	private String serial;
}
