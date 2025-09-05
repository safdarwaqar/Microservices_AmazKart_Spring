package com.microsvs.user.excepetion;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microsvs.user.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {

	// Bean validation generic exception...
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	// User already present exception handler...
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExists ex, HttpServletRequest request) {

		return new ResponseEntity<>(setErrorAttributes(HttpStatus.CONFLICT, ex.getMessage()), HttpStatus.CONFLICT);
	}

	// user not found exception handler...
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFound ex) {

		return new ResponseEntity<>(setErrorAttributes(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	// Error response generator...
	private ErrorResponse setErrorAttributes(HttpStatus status, String message) {
		return ErrorResponse.builder().status(status.value()).error(status).message(message)
				.timestamp(LocalDateTime.now()).build();
	}

}
