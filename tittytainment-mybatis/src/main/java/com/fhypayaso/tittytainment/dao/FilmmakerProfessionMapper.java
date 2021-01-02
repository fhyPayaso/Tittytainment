package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.FilmmakerProfession;
import java.util.List;

public interface FilmmakerProfessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FilmmakerProfession record);

    FilmmakerProfession selectByPrimaryKey(Long id);

    List<FilmmakerProfession> selectAll();

    int updateByPrimaryKey(FilmmakerProfession record);
}