package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import java.util.List;

public interface FilmmakerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Filmmaker record);

    Filmmaker selectByPrimaryKey(Long id);

    List<Filmmaker> selectAll();

    int updateByPrimaryKey(Filmmaker record);
}