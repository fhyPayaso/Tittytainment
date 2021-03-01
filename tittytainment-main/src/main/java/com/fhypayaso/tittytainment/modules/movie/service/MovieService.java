package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieParam;
import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.Profession;
import com.github.pagehelper.PageInfo;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 1:12 上午
#   @Description   : 
# ====================================================*/
public interface MovieService {

    int insert(MovieParam qvo);

    int insert(Movie movie);

    int deleteAll();

    int insertMovieFilmmaker(Movie movie, Filmmaker filmmaker, Profession profession);


    int deleteAllMovieFilmmaker();


    MovieVO queryById(Long id, Boolean withActorInfo) throws ApiException;

    MovieVO queryByDoubanId(Long dbId, Boolean withActorInfo) throws ApiException;

    PageInfo<MovieVO> queryMovieByYear(Integer year, Integer offset, Integer count) throws ApiException;

    PageInfo<MovieVO> queryMovieWithCover(Integer offset, Integer count) throws ApiException;


    void deleteById(Long id) throws ApiException;

    int update(MovieParam qvo) throws ApiException;

    List<Movie> queryAll();

    MovieVO wrapMovie(Movie movie, Boolean withActorInfo) throws ApiException;

}
