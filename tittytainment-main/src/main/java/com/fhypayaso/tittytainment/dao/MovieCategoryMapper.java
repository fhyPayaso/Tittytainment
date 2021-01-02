package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MovieCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieCategory record);

    MovieCategory selectByPrimaryKey(Long id);

    List<MovieCategory> selectAll();

    int updateByPrimaryKey(MovieCategory record);

    int deleteAll();
}