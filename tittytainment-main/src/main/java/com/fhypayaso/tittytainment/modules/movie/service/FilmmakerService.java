package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.filmmaker.FilmmakerVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.pojo.entity.Category;
import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.MovieFilmmaker;
import com.github.pagehelper.PageInfo;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:14 上午
#   @Description   : 
# ====================================================*/
public interface FilmmakerService {

    int insert(Filmmaker filmmaker);

    int deleteAll();

    Filmmaker queryByDoubanId(Long dbId);

    FilmmakerVO queryById(Long id, Boolean withMovieInfo) throws ApiException;

    PageInfo<MovieVO> queryMoviesByFilmmaker(Long filmmakerId, Integer offset, Integer count) throws ApiException;


    int deleteById(Long id);

    int update(Filmmaker filmmaker);

    List<Filmmaker> queryAll();


    List<MovieFilmmaker> queryMovieFilmmaker(Long movieId);
}
