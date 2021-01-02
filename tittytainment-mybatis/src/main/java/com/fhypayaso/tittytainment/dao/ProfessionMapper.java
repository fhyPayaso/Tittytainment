package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Profession;
import java.util.List;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Profession record);

    Profession selectByPrimaryKey(Long id);

    List<Profession> selectAll();

    int updateByPrimaryKey(Profession record);
}