package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieFilmmaker;
import java.util.List;

public interface MovieFilmmakerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieFilmmaker record);

    MovieFilmmaker selectByPrimaryKey(Long id);

    List<MovieFilmmaker> selectAll();

    int updateByPrimaryKey(MovieFilmmaker record);
}