package com.microsvs.user.excepetion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microsvs.user.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExists ex, HttpServletRequest request) {

		return new ResponseEntity<>(setErrorAttributes(HttpStatus.CONFLICT, ex.getMessage()), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFound ex) {

		return new ResponseEntity<>(setErrorAttributes(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	private ErrorResponse setErrorAttributes(HttpStatus status, String message) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(status.value());
		error.setError(status);
		error.setMessage(message);
		error.setTimestamp(LocalDateTime.now());
		return error;
	}

}
