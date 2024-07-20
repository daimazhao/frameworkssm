package com.its.service.impl;

import com.its.entity.Products;
import com.its.entity.Student;
import com.its.mapper.ProductMapper;
import com.its.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Products> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public Products queryProductById(int id) {
        return productMapper.queryProductById(id);
    }
}
