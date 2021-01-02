package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieLanguage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MovieLanguageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieLanguage record);

    MovieLanguage selectByPrimaryKey(Long id);

    List<MovieLanguage> selectAll();

    int updateByPrimaryKey(MovieLanguage record);

    int deleteAll();
}