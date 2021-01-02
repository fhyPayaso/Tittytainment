package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    Category selectByPrimaryKey(Long id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);

    int deleteAll();
}