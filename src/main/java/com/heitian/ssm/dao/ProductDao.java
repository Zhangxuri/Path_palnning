package com.heitian.ssm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.heitian.ssm.model.Product;

@Mapper
public interface ProductDao {
    int insert(@Param("product") Product product);

    int insertSelective(@Param("product") Product product);

    int insertList(@Param("products") List<Product> products);

    int update(@Param("product") Product product);

    Product findbyId(@Param("id")Long id);

    List<Product> find();


}
