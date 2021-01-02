package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.MovieRegion;
import java.util.List;

public interface MovieRegionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieRegion record);

    MovieRegion selectByPrimaryKey(Long id);

    List<MovieRegion> selectAll();

    int updateByPrimaryKey(MovieRegion record);
}