package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.Profession;
import com.fhypayaso.tittytainment.pojo.entity.Region;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:15 上午
#   @Description   : 
# ====================================================*/
public interface RegionService {

    Long insert(String regionName);

    int insertMovieRegion(Movie movie, Long regionId);

    int deleteAll();

    int deleteAllMovieRegion();



    Region queryById(Long id);

    int deleteById(Long id);

    int update(Region region);

    List<Region> queryAll();
}
