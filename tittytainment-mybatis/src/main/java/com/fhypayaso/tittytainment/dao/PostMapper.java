package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Post;
import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Post record);

    Post selectByPrimaryKey(Long id);

    List<Post> selectAll();

    int updateByPrimaryKey(Post record);
}