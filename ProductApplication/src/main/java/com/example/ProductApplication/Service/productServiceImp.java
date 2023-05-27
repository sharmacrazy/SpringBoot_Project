package com.example.ProductApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ProductApplication.Dao.ProductDao;
import com.example.ProductApplication.Modal.ProductModal;

@Service
public class productServiceImp implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public List<ProductModal> getAllProduct(int pageSize) {
		
		Pageable p = PageRequest.ofSize(pageSize);
		Page<ProductModal> list = productDao.findAll(p);
		List<ProductModal> newList = list.getContent(); 
		return newList;
	}

	@Override
	public ProductModal addProducts(ProductModal productModal) {

		ProductModal productList = productDao.save(productModal);
		return productList;
	}

	@Override
	public ProductModal getById(int pId) {

		ProductModal product = productDao.findById(pId).get();
		return product;
	}

	@Override
	public String updateProduct(int pId,ProductModal productModal) {
		
		int productId = pId;
		String productName = productModal.getProductName();
		String prodcategory = productModal.getProductPrice();
		 
		 Optional<ProductModal> checkList=productDao.findById(productId);

		 if(checkList.isPresent()) {
			 ProductModal listForUpdate = checkList.get();
			 listForUpdate.setProductName((productName == null)? listForUpdate.getProductName():productName);
			 listForUpdate.setProductPrice((prodcategory == null)? listForUpdate.getProductPrice():prodcategory);
			 productDao.save(listForUpdate);
			 return "Update Successfully";
		 }else {
			 return "Record Not Found";
		 }
	}

	@Override
	public String deleteContact(int pId) {
		
		Optional<ProductModal> checkList=productDao.findById(pId);
		
		if(checkList.isPresent()) {
			
			productDao.deleteById(pId);
			return "Delete Successfully";
		 }else {
			 return "invalid Not Found";
		 }
		
	}

}
