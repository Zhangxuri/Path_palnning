package com.heitian.ssm.service;

import java.util.List;
import com.heitian.ssm.model.ProductList;
public interface ProductListService{

    int insert(ProductList productList);

    int insertSelective(ProductList productList);

    int insertList(List<ProductList> productLists);

    int update(ProductList productList);

    List<ProductList> find();

    List<Long> findProduct();


}
