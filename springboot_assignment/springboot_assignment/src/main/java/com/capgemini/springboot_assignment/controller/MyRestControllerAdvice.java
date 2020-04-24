package com.capgemini.springboot_assignment.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springboot_assignment.dto.ProductResponse;
import com.capgemini.springboot_assignment.exception.ProductException;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler
	public ProductResponse myExceptionHandler(ProductException productException) {
		ProductResponse response = new ProductResponse();
		response.setError(true);
		response.setMessage(productException.getMessage());
		return response;
	}
}
