package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.MovieRegionMapper;
import com.fhypayaso.tittytainment.dao.RegionMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.dto.region.RegionVO;
import com.fhypayaso.tittytainment.modules.movie.service.MovieService;
import com.fhypayaso.tittytainment.modules.movie.service.RegionService;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.MovieRegion;
import com.fhypayaso.tittytainment.pojo.entity.Region;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:31 上午
#   @Description   : 
# ====================================================*/
@Slf4j
@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Resource
    private MovieRegionMapper movieRegionMapper;

    @Resource
    private MovieService movieService;


    @Override
    public Long insert(String regionName) {

        Region region = new Region();
        region.setRegionName(regionName);
        region.setCreatedTime(new Date(System.currentTimeMillis()));
        region.setUpdatedTime(new Date(System.currentTimeMillis()));
        regionMapper.insert(region);

        return region.getId();
    }

    @Override
    public int insertMovieRegion(Movie movie, Long regionId) {

        MovieRegion movieRegion = new MovieRegion();

        movieRegion.setMovieId(movie.getId());
        movieRegion.setMovieDoubanId(movie.getDoubanId());
        movieRegion.setRegionId(regionId);
        movieRegion.setCreatedTime(new Date(System.currentTimeMillis()));
        movieRegion.setUpdatedTime(new Date(System.currentTimeMillis()));

        return movieRegionMapper.insert(movieRegion);
    }

    @Override
    public int deleteAll() {
        return regionMapper.deleteAll();
    }

    @Override
    public int deleteAllMovieRegion() {
        return movieRegionMapper.deleteAll();
    }

    @Override
    public Region queryById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int update(Region region) {
        return 0;
    }

    @Override
    public List<RegionVO> queryAll() {

        List<Region> regions = regionMapper.selectAll();

        List<RegionVO> voList = regions.stream()
                .map(region -> {
                    RegionVO vo = new RegionVO();
                    BeanUtils.copyProperties(region, vo);
                    return vo;
                })
                .collect(Collectors.toList());

        return voList;
    }

    @Override
    public List<RegionVO> queryByMovie(Long movieId) {

        List<MovieRegion> movieRegionList = movieRegionMapper.selectByMovie(movieId);
        List<RegionVO> regions = new ArrayList<>();
        if (!CollectionUtils.isEmpty(movieRegionList)) {
            for (MovieRegion mr : movieRegionList) {
                Region region = regionMapper.selectByPrimaryKey(mr.getRegionId());
                if (region != null) {
                    RegionVO vo = new RegionVO();
                    BeanUtils.copyProperties(region, vo);
                    regions.add(vo);
                }
            }
        }
        return regions;
    }

    @Override
    public PageInfo<MovieVO> queryMovieByRegion(Long regionId, Integer offset, Integer count) throws ApiException {

        PageHelper.offsetPage(offset, count);
        List<MovieRegion> movieRegions   = movieRegionMapper.selectByRegion(regionId);

        List<MovieVO> voList = new ArrayList<>();
        for (MovieRegion mr : movieRegions) {
            voList.add(movieService.queryById(mr.getMovieId(),false));
        }

        return new PageInfo<>(voList);
    }
}
