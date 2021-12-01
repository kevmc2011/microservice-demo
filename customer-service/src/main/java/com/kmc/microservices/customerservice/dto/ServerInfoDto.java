package com.kmc.microservices.customerservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ServerInfoDto {
	private String address;
}
