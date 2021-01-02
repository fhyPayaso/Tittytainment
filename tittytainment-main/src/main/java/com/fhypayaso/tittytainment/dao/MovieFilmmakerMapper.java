package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieFilmmaker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MovieFilmmakerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieFilmmaker record);

    MovieFilmmaker selectByPrimaryKey(Long id);

    List<MovieFilmmaker> selectAll();

    int updateByPrimaryKey(MovieFilmmaker record);

    int deleteAll();
}