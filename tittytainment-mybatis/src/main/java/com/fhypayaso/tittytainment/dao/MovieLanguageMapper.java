package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieLanguage;
import java.util.List;

public interface MovieLanguageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieLanguage record);

    MovieLanguage selectByPrimaryKey(Long id);

    List<MovieLanguage> selectAll();

    int updateByPrimaryKey(MovieLanguage record);
}