package com.capgemini.springboot_assignment.dao;

import java.util.List;

import com.capgemini.springboot_assignment.dto.ProductPrimary;


public interface ProductDAO {
	boolean updateProductInfo(ProductPrimary info);
	boolean deleteProductInfo(String productName);
	boolean createProductInfo(ProductPrimary info);
	List<ProductPrimary>  getAllRecordsProduct();
}
