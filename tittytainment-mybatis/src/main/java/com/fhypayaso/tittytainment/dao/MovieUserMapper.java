package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieUser;
import java.util.List;

public interface MovieUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieUser record);

    MovieUser selectByPrimaryKey(Long id);

    List<MovieUser> selectAll();

    int updateByPrimaryKey(MovieUser record);
}