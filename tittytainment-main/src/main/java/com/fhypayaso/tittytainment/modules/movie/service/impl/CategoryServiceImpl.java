package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.CategoryMapper;
import com.fhypayaso.tittytainment.dao.MovieCategoryMapper;
import com.fhypayaso.tittytainment.modules.movie.service.CategoryService;
import com.fhypayaso.tittytainment.pojo.entity.Category;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.MovieCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:24 上午
#   @Description   : 
# ====================================================*/

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {


    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private MovieCategoryMapper movieCategoryMapper;


    @Override
    public Long insert(String categoryName) {

        Category categoryModel = new Category();
        categoryModel.setCategoryName(categoryName);
        categoryModel.setCreatedTime(new Date(System.currentTimeMillis()));
        categoryModel.setUpdatedTime(new Date(System.currentTimeMillis()));
        categoryMapper.insert(categoryModel);

        return categoryModel.getId();
    }

    @Override
    public int insertMovieCategory(Movie movie, Long categoryId) {

        MovieCategory movieCategory = new MovieCategory();
        movieCategory.setMovieId(movie.getId());
        movieCategory.setMovieDoubanId(movie.getDoubanId());
        movieCategory.setCategoryId(categoryId);
        movieCategory.setCreatedTime(new Date(System.currentTimeMillis()));
        movieCategory.setUpdatedTime(new Date(System.currentTimeMillis()));

        return movieCategoryMapper.insert(movieCategory);
    }

    @Override
    public int deleteAll() {
        return categoryMapper.deleteAll();
    }

    @Override
    public int deleteAllMovieCategory() {
        return movieCategoryMapper.deleteAll();
    }


    @Override
    public Category queryById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int update(Category category) {
        return 0;
    }

    @Override
    public List<Category> queryAll() {
        return null;
    }
}
