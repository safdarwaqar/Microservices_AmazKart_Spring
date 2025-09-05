package com.microsvs.inventory.service.kafka;

import java.util.UUID;

import lombok.Data;

@Data
public class OrderPlacedEvent {
	
	private UUID productId;
	
	private int quantity;

}
