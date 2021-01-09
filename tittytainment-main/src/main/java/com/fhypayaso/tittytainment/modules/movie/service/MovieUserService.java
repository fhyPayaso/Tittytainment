package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.github.pagehelper.PageInfo;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/7 5:39 下午
#   @Description   : 
# ====================================================*/
public interface MovieUserService {


    void wannaSeeMovie(Long movieId) throws ApiException;

    void cancelWannaSeeMovie(Long movieId) throws ApiException;

    void haveSeenMovie(Long movieId) throws ApiException;

    void ratingMovie(Long movieId, Double score) throws ApiException;

    PageInfo<MovieVO> queryAllWannaSee(Integer offset, Integer count) throws ApiException;

    PageInfo<MovieVO> queryAllHaveSee(Integer offset, Integer count) throws ApiException;

}
