package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Topic;
import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Topic record);

    Topic selectByPrimaryKey(Long id);

    List<Topic> selectAll();

    int updateByPrimaryKey(Topic record);
}