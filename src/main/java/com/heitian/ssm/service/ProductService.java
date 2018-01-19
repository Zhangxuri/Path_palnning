package com.heitian.ssm.service;

import java.util.List;
import com.heitian.ssm.model.Product;
import com.heitian.ssm.model.ProductList;
import org.apache.ibatis.annotations.Param;

public interface ProductService{

    int insert(Product product);

    int insertSelective(Product product);

    int insertList(List<Product> products);

    int update(Product product);

    Product findbyId(Long id);

    List<Product> find();

}
