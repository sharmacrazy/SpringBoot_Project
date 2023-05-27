package com.example.ProductApplication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductApplication.Modal.CategoryModal;

public interface CategoryDao extends JpaRepository<CategoryModal, Integer> {

}
