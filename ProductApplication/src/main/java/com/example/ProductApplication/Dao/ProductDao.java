package com.example.ProductApplication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductApplication.Modal.ProductModal;

public interface ProductDao extends JpaRepository<ProductModal, Integer>{

}
