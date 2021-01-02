package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Language;
import java.util.List;

public interface LanguageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Language record);

    Language selectByPrimaryKey(Long id);

    List<Language> selectAll();

    int updateByPrimaryKey(Language record);
}