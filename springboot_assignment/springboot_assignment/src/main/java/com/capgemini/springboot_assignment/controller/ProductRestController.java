package com.capgemini.springboot_assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot_assignment.dto.ProductPrimary;
import com.capgemini.springboot_assignment.dto.ProductResponse;
import com.capgemini.springboot_assignment.service.ProductService;

@RestController
public class ProductRestController {


	@Autowired
	private ProductService service;

	@PostMapping(path = "/addProduct", 
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	//@ResponseBody
	public ProductResponse addProduct(@RequestBody ProductPrimary productInfo) {

		boolean isAdded =  service.createProductInfo(productInfo);

		ProductResponse response = new ProductResponse();

		if(isAdded) {
			response.setMessage("Record is inserted Successfully");
		} else {
			response.setError(true);
			response.setMessage("Record is not inserted");
		}
		return response;
	}//End of addProduct

	@GetMapping(path="/getAllProducts",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	//@ResponseBody
	public ProductResponse getAllProducts() {
		List<ProductPrimary> recordList = service.getAllRecordsProduct();

		ProductResponse response = new ProductResponse();
		if(recordList != null && !recordList.isEmpty()) {
			response.setProductsinfo(recordList);
		} else {
			response.setError(true);
			response.setMessage("Product List not present");
		}
		return response;
	}//End of getAllProducts

	@PutMapping(path = "/updateProduct",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse updateProduct(@RequestBody ProductPrimary info) {
		boolean isUpdated = service.updateProductInfo(info);

		ProductResponse response = new ProductResponse();
		if(isUpdated) {
			response.setMessage("Record is updated");
		} else {
			response.setError(true);
			response.setMessage("Record not updated");
		}
		return response;
	}//End of updateProduct

	@DeleteMapping(path="/deleteProduct/{productName}",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse deleteProduct(@PathVariable(name="productName") String productName) {

		boolean isDeleted = service.deleteProductInfo(productName);

		ProductResponse response = new ProductResponse();
		if(isDeleted) {
			response.setMessage("Record deleted");
		} else {
			response.setError(true);
			response.setMessage("Record not deleted");
		}
		return response;
	}


}
