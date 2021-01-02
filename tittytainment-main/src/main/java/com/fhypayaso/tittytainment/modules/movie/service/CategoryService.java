package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.pojo.entity.Category;
import com.fhypayaso.tittytainment.pojo.entity.Movie;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:14 上午
#   @Description   : 
# ====================================================*/
public interface CategoryService {

    Long insert(String categoryName);


    int insertMovieCategory(Movie movie, Long categoryId);

    int deleteAll();

    int deleteAllMovieCategory();




    Category queryById(Long id);

    int deleteById(Long id);

    int update(Category category);

    List<Category> queryAll();
}

