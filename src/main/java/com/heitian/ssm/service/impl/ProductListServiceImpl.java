package com.heitian.ssm.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.heitian.ssm.model.ProductList;
import com.heitian.ssm.dao.ProductListDao;
import com.heitian.ssm.service.ProductListService;

@Service
public class ProductListServiceImpl implements ProductListService{

    @Resource
    private ProductListDao productListDao;

    public int insert(ProductList productList){
        return productListDao.insert(productList);
    }

    public int insertSelective(ProductList productList){
        return productListDao.insertSelective(productList);
    }

    public int insertList(List<ProductList> productLists){
        return productListDao.insertList(productLists);
    }

    public int update(ProductList productList){
        return productListDao.update(productList);
    }

    public List<ProductList> find() {
        return productListDao.find();
    }

    @Override
    public List<Long> findProduct() {
        return productListDao.findProduct();
    }
}
