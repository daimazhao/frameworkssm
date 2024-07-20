package com.its.service;

import com.its.entity.Products;

import java.util.List;

public interface ProductService {

    List<Products> selectAll();

    Products queryProductById(int id);

}
