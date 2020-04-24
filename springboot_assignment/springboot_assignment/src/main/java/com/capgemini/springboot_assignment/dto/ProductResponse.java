package com.capgemini.springboot_assignment.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

	private boolean error;
	private String message;

	private ProductPrimary productInfo;
	private List<ProductPrimary> productsinfo;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ProductPrimary getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductPrimary productInfo) {
		this.productInfo = productInfo;
	}
	public List<ProductPrimary> getProductsinfo() {
		return productsinfo;
	}
	public void setProductsinfo(List<ProductPrimary> productsinfo) {
		this.productsinfo = productsinfo;
	}
	
	
}
