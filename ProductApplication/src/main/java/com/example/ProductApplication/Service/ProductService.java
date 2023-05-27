package com.example.ProductApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProductApplication.Modal.ProductModal;

@Service
public interface ProductService {

	List<ProductModal> getAllProduct(int pageSize);

	ProductModal addProducts(ProductModal productModal);

	ProductModal getById(int pId);

	String updateProduct(int pId, ProductModal productModal);

	String deleteContact(int pId);

}
