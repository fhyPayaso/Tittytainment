package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.Post;
import com.fhypayaso.tittytainment.pojo.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Post record);

    Post selectByPrimaryKey(Long id);

    List<Post> selectByTopic(Long topicId);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);

    int deleteAllPostByTopic(Long topicId);

    List<Post> selectNum(Integer num);
}