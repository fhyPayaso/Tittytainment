package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    Category selectByPrimaryKey(Long id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}