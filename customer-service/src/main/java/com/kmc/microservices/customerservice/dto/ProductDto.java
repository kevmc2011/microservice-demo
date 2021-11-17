package com.kmc.microservices.customerservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4111279729195960296L;
	private String sku;
	private String serial;
}
