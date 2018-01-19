package com.heitian.ssm.service.impl;

import com.heitian.ssm.model.Product;
import com.heitian.ssm.service.ProductService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.heitian.ssm.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    public int insert(Product product){
        return productDao.insert(product);
    }

    public int insertSelective(Product product){
        return productDao.insertSelective(product);
    }

    public int insertList(List<Product> products){
        return productDao.insertList(products);
    }

    public int update(Product product){
        return productDao.update(product);
    }

    @Override
    public Product findbyId(Long id) {
        return productDao.findbyId(id);
    }

    @Override
    public List<Product> find() {
        return productDao.find();
    }
}
