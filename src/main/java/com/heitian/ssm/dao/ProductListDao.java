package com.heitian.ssm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.heitian.ssm.model.ProductList;

@Mapper
public interface ProductListDao {
    int insert(@Param("productList") ProductList productList);

    int insertSelective(@Param("productList") ProductList productList);

    int insertList(@Param("productLists") List<ProductList> productLists);

    int update(@Param("productList") ProductList productList);

    List<ProductList> find();

    List<Long> findProduct();



}
