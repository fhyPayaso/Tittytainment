package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.language.LanguageVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.pojo.entity.Language;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.github.pagehelper.PageInfo;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:14 上午
#   @Description   : 
# ====================================================*/
public interface LanguageService {

    Long insert(String name);


    int insertMovieLanguage(Movie movie, Long languageId);

    int deleteAll();

    int deleteAllMovieLanguage();

    Language queryById(Long id);


    List<LanguageVO> queryByMovie(Long id);


    int deleteById(Long id);

    int update(Language language);

    List<LanguageVO> queryAll();

    PageInfo<MovieVO> queryMovieByLanguage(Long languageId, Integer offset, Integer count) throws ApiException;
}
