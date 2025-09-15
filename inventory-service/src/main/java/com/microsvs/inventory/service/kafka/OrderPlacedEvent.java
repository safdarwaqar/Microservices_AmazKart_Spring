package com.microsvs.inventory.service.kafka;

import lombok.Data;

@Data
public class OrderPlacedEvent {
	
	private Long productId;
	
	private int quantity;

}
