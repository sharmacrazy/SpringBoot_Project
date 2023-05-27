package com.example.ProductApplication.Modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "category_details")
public class CategoryModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name ="category_type")
	private String categoryType;
	
	@OneToMany(targetEntity = ProductModal.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id", referencedColumnName = "categoryId")
	private List<ProductModal> products;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public List<ProductModal> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModal> products) {
		this.products = products;
	}

}
