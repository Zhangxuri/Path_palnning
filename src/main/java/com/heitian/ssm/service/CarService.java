package com.heitian.ssm.service;

import java.util.List;
import com.heitian.ssm.model.Car;
import org.apache.ibatis.annotations.Param;

public interface CarService{

    int insert(Car car);

    int insertSelective(Car car);

    int insertList(List<Car> cars);

    int update(Car car);

    List<Car> findbyVolumgreaterThan(Double minVolum);

}
