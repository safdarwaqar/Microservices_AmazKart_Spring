package com.microsvs.inventory.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microsvs.inventory.entity.InventoryItem;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, UUID> {

	Optional<InventoryItem> findByProductId(UUID productId);

}
