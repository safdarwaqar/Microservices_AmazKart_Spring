package com.microsvs.user.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	private int status; // HTTP status code (e.g., 404, 500)

	private HttpStatus error; // Short error type (e.g., "Not Found", "Internal Server Error")

	private String message; // Detailed error message

	private LocalDateTime timestamp; // Time of the error (ISO 8601 format recommended)

}
