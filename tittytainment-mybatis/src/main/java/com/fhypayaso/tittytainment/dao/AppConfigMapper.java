package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.AppConfig;
import java.util.List;

public interface AppConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppConfig record);

    AppConfig selectByPrimaryKey(Long id);

    List<AppConfig> selectAll();

    int updateByPrimaryKey(AppConfig record);
}