package com.microsvs.inventory.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microsvs.inventory.dto.UserResponseDTO;

@FeignClient(name = "user-service", path = "/api/users")
public interface UserClient {

	@GetMapping("/{id}")
	UserResponseDTO getUserById(@PathVariable String id);

	@GetMapping
	List<UserResponseDTO> getAllUsers();

}
