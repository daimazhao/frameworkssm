package com.its.mapper;

import com.its.entity.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Products> selectAll();

    Products queryProductById(int id);
}
