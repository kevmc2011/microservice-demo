package com.kmc.microservices.orderservice.domain;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.kmc.microservices.orderservice.projections.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1342358516213989015L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long customerId;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_products", 
			  joinColumns = @JoinColumn(name = "order_id"), 
			  inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	public static OrderDto convertToDto(Order order) {
		return OrderDto.builder()
				.customerId(order.getCustomerId())
				.products(order.getProducts().stream().map(Product::convertToDto).collect(Collectors.toList()))
				.build();
	}

	public static Order convertToEntity(OrderDto orderDto) {
		return Order.builder()
				.customerId(orderDto.getCustomerId())
				.products(orderDto.getProducts().stream().map(Product::convertToEntity).collect(Collectors.toList()))
				.build();
	}
}
