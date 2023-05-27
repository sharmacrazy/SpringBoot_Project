package com.example.ProductApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ProductApplication.Dao.CategoryDao;
import com.example.ProductApplication.Modal.CategoryModal;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryDao CategoryDao;
	
	@Override
	public List<CategoryModal> getAllProduct(int pageSize) {
		
		Pageable p=PageRequest.ofSize(pageSize);
		Page<CategoryModal> listOfCategory = CategoryDao.findAll(p);
		List<CategoryModal> list= listOfCategory.getContent();
		
		return list;
	}

	@Override
	public CategoryModal addCategory(CategoryModal categoryModal) {
		
		CategoryModal listOfCategory = CategoryDao.save(categoryModal);
		return listOfCategory;
	}

	@Override
	public CategoryModal getById(int cId) {
		
		CategoryModal categoryModal = CategoryDao.findById(cId).get(); 
		return categoryModal;
	}

	@Override
	public String updateProduct(int cId, CategoryModal categoryModal) {
		int categoryId = cId;
		String categoryType = categoryModal.getCategoryType();
		 
		 Optional<CategoryModal> checkList=CategoryDao.findById(categoryId);

		 if(checkList.isPresent()) {
			 CategoryModal listForUpdate = checkList.get();
			 listForUpdate.setCategoryType((categoryType == null)? listForUpdate.getCategoryType():categoryType);
			 CategoryDao.save(listForUpdate);
			 return "Update Successfully";
		 }else {
			 return "Record Not Found";
		 }
	}

	@Override
	public String deleteCategroy(int cId) {
		
		Optional<CategoryModal> checkList=CategoryDao.findById(cId);
		
		if(checkList.isPresent()) {
			
			CategoryDao.deleteById(cId);
			return "Delete Successfully";
		 }else {
			 return "invalid Not Found";
		 }
		
	}

}
