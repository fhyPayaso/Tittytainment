package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Topic record);

    Topic selectByPrimaryKey(Long id);

    Topic selectByMovie(Long movieId);

    List<Topic> selectAll();

    int updateByPrimaryKey(Topic record);
}