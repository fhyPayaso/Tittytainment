package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Movie record);

    Movie selectByPrimaryKey(Long id);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);
}