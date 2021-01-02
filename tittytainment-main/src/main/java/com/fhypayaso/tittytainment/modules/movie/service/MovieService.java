package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.Profession;
import com.fhypayaso.tittytainment.pojo.entity.User;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 1:12 上午
#   @Description   : 
# ====================================================*/
public interface MovieService {

    int insert(Movie movie);

    int deleteAll();

    int insertMovieFilmmaker(Movie movie, Filmmaker filmmaker, Profession profession);


    int deleteAllMovieFilmmaker();


    Movie queryById(Long id);

    Movie queryByDoubanId(Long dbId);

    int deleteById(Long id);

    int update(Movie movie);

    List<Movie> queryAll();

}
