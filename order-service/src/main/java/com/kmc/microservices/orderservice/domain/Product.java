package com.kmc.microservices.orderservice.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.kmc.microservices.orderservice.projections.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String sku;

	private String serial;

	@ManyToMany(mappedBy = "products")
	private List<Order> orders;

	public static ProductDto convertToDto(Product product) {
		return ProductDto.builder()
				.serial(product.getSerial())
				.sku(product.getSku())
				.build();
	}

	public static Product convertToEntity(ProductDto productDto) {
		return Product.builder()
				.sku(productDto.getSku())
				.serial(productDto.getSerial())
				.build();
	}
}
