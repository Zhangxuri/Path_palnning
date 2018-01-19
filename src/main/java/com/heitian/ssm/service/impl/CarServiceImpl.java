package com.heitian.ssm.service.impl;

import com.heitian.ssm.model.Car;
import com.heitian.ssm.service.CarService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.heitian.ssm.dao.CarDao;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarDao carDao;

    public int insert(Car car){
        return carDao.insert(car);
    }

    public int insertSelective(Car car){
        return carDao.insertSelective(car);
    }

    public int insertList(List<Car> cars){
        return carDao.insertList(cars);
    }

    public int update(Car car){
        return carDao.update(car);
    }

    @Override
    public List<Car> findbyVolumgreaterThan(Double minVolum) {
        return carDao.findbyVolumgreaterThan(minVolum);
    }
}
