package com.example.ProductApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductApplication.Modal.ProductModal;
import com.example.ProductApplication.Service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="/getAllProducts",method=RequestMethod.GET)
	public List<ProductModal> getAllProducts(
			@RequestParam(value = "pageSize",defaultValue = "2",required = false) int pageSize
			) {
		
		List<ProductModal> listOfproducts = productService.getAllProduct(pageSize);
		return listOfproducts;
	}
	
	@RequestMapping(value="/addProducts",method=RequestMethod.POST)
	public ProductModal addProducts(@RequestBody ProductModal productModal) {
		
		ProductModal productList = productService.addProducts(productModal);
		return productList;
	}
	
	@RequestMapping(value="/Products/{id}",method=RequestMethod.GET)
	public ProductModal getById(@PathVariable("id") int pId ) {
		
		ProductModal list = productService.getById(pId);
		return list;
	}
	
	@RequestMapping(value="/updateProducts/{id}",method=RequestMethod.PUT)
	public String updateProduct(@PathVariable("id")int pId,@RequestBody ProductModal productModal) {
		
	    String message = productService.updateProduct(pId,productModal);
		return message;
	}
	
	@RequestMapping(value="/deleteProduct/{id}",method=RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") int pId) {
		
		String message = productService.deleteContact(pId);
		return message;
	}
}
