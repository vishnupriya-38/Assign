package com.capgemini.springboot_assignment.service;

import java.util.List;

import com.capgemini.springboot_assignment.dto.ProductPrimary;

public interface ProductService {
	boolean updateProductInfo(ProductPrimary info);
	boolean deleteProductInfo(String productName);
	boolean createProductInfo(ProductPrimary info);
	List<ProductPrimary>  getAllRecordsProduct();

}
