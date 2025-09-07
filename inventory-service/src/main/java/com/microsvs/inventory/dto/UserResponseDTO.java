package com.microsvs.inventory.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
