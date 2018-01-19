package com.heitian.ssm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.heitian.ssm.model.Car;

@Mapper
public interface CarDao {
    int insert(@Param("car") Car car);

    int insertSelective(@Param("car") Car car);

    int insertList(@Param("cars") List<Car> cars);

    int update(@Param("car") Car car);

    List<Car> findbyVolumgreaterThan(@Param("minVolum")Double minVolum);


}
