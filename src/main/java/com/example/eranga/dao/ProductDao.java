package com.example.eranga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eranga.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
