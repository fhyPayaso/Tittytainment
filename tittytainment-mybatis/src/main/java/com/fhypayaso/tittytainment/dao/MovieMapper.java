package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    Movie selectByPrimaryKey(Integer id);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);
}