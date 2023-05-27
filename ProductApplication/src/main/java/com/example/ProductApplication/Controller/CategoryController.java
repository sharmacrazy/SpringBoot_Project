package com.example.ProductApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductApplication.Modal.CategoryModal;
import com.example.ProductApplication.Service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/getAllCategory",method=RequestMethod.GET)
	public List<CategoryModal> getAllCategory(
			@RequestParam(value = "pageSize",defaultValue = "2",required = false) int pageSize
			) {
		
		List<CategoryModal> listOfCategory = categoryService.getAllProduct(pageSize);
		return listOfCategory;
	}
	
	@RequestMapping(value="/addCategroy",method=RequestMethod.POST)
	public CategoryModal addCategroy(@RequestBody CategoryModal categoryModal) {
		
		CategoryModal listOfCategory = categoryService.addCategory(categoryModal);
		return listOfCategory;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	public CategoryModal getById(@PathVariable("id") int cId ) {
		
		CategoryModal list = categoryService.getById(cId);
		return list;
	}
	
	@RequestMapping(value="/updateCategory/{id}",method=RequestMethod.PUT)
	public String updateCategory(@PathVariable("id")int cId,@RequestBody CategoryModal categoryModal) {
		
	    String message = categoryService.updateProduct(cId,categoryModal);
		return message;
	}
	
	@RequestMapping(value="/deleteCategroy/{id}",method=RequestMethod.DELETE)
	public String deleteCategroy(@PathVariable("id") int cId) {
		
		String message = categoryService.deleteCategroy(cId);
		return message;
	}

}
