package com.example.ProductApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProductApplication.Modal.CategoryModal;

@Service
public interface CategoryService {

	List<CategoryModal> getAllProduct(int pageSize);

	CategoryModal addCategory(CategoryModal categoryModal);

	CategoryModal getById(int cId);

	String updateProduct(int cId, CategoryModal categoryModal);

	String deleteCategroy(int cId);

}
