package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Like;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Like record);

    Like selectByPrimaryKey(Long id);

    List<Like> selectAll();

    int updateByPrimaryKey(Like record);
}