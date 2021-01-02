package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.MovieFilmmakerMapper;
import com.fhypayaso.tittytainment.dao.MovieMapper;
import com.fhypayaso.tittytainment.modules.movie.service.*;
import com.fhypayaso.tittytainment.pojo.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 1:12 上午
#   @Description   : 
# ====================================================*/

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieMapper movieMapper;


    @Resource
    private MovieFilmmakerMapper movieFilmmakerMapper;


    @Override
    public int insert(Movie movie) {
        movie.setCreatedTime(new Date(System.currentTimeMillis()));
        movie.setUpdatedTime(new Date(System.currentTimeMillis()));
        return movieMapper.insert(movie);
    }

    @Override
    public int deleteAll() {
        return movieMapper.deleteAll();
    }

    @Override
    public int insertMovieFilmmaker(Movie movie, Filmmaker filmmaker, Profession profession) {


        if(movie == null || filmmaker == null || profession == null) {
            log.error("电影-演员关系插入失败");
            return 0;
        }


        MovieFilmmaker movieFilmmaker = new MovieFilmmaker();

        movieFilmmaker.setMovieId(movie.getId());
        movieFilmmaker.setMovieDoubanId(movie.getDoubanId());
        movieFilmmaker.setFilmmakerId(filmmaker.getId());
        movieFilmmaker.setFilmmakerDoubanId(filmmaker.getDoubanId());
        movieFilmmaker.setProfessionId(profession.getId());
        movieFilmmaker.setCreatedTime(new Date(System.currentTimeMillis()));
        movieFilmmaker.setUpdatedTime(new Date(System.currentTimeMillis()));

        return movieFilmmakerMapper.insert(movieFilmmaker);
    }

    @Override
    public int deleteAllMovieFilmmaker() {
        return movieFilmmakerMapper.deleteAll();
    }


    @Override
    public Movie queryById(Long id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Override
    public Movie queryByDoubanId(Long dbId) {
        return movieMapper.selectByDoubanId(dbId);
    }

    @Override
    public int deleteById(Long id) {
        return movieMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Movie movie) {
        return movieMapper.updateByPrimaryKey(movie);
    }

    @Override
    public List<Movie> queryAll() {
        return movieMapper.selectAll();
    }
}
