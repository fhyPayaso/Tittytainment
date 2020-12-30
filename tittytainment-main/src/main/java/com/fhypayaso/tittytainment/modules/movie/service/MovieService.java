package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
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

    int insert(Movie user);

    Movie queryById(Integer id);

    int deleteById(Integer id);

    int updateById(User user);

    List<Movie> queryAll();

}
