package com.microsvs.inventory.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsvs.inventory.service.InventoryService;

@Component
public class OrderEventListener {

	@Autowired
	private InventoryService inventoryService;

	@KafkaListener(topics = "order-placed", groupId = "inventory-group")
	public void handleOrderPlaced(String message) {
		// Parse JSON message
		OrderPlacedEvent event = parseEvent(message);
		inventoryService.updateStock(event.getProductId(), event.getQuantity());
	}

	private OrderPlacedEvent parseEvent(String message) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(message, OrderPlacedEvent.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Failed to parse event", e);
		}
	}

}
