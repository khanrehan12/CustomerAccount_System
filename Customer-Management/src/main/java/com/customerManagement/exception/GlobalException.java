package com.customerManagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex) {

		Map map = new HashMap();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	
	@ExceptionHandler(NotAcceptableException.class)
	public ResponseEntity<Map<String, Object>> notAcceptableHandler(NotAcceptableException ex) {

		Map map = new HashMap();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_ACCEPTABLE);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}
