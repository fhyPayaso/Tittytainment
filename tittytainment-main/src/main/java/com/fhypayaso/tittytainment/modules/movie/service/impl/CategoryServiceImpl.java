package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.CategoryMapper;
import com.fhypayaso.tittytainment.dao.MovieCategoryMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.category.CategoryVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.service.CategoryService;
import com.fhypayaso.tittytainment.modules.movie.service.MovieService;
import com.fhypayaso.tittytainment.pojo.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Resource
    private MovieService movieService;


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
    public List<CategoryVO> queryByMovie(Long movieId) {

        List<MovieCategory> movieCategories = movieCategoryMapper.selectByMovie(movieId);
        List<CategoryVO> categories = new ArrayList<>();

        if (!CollectionUtils.isEmpty(movieCategories)) {
            for (MovieCategory mc : movieCategories) {
                Category category = categoryMapper.selectByPrimaryKey(mc.getCategoryId());
                if (category != null) {
                    CategoryVO vo = new CategoryVO();
                    BeanUtils.copyProperties(category, vo);
                    categories.add(vo);
                }
            }
        }

        return categories;
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
    public List<CategoryVO> queryAll() {

        List<Category> categories = categoryMapper.selectAll();

        List<CategoryVO> voList = categories.stream()
                .map(category -> {
                    CategoryVO vo = new CategoryVO();
                    BeanUtils.copyProperties(category, vo);
                    return vo;
                })
                .collect(Collectors.toList());

        return voList;
    }

    @Override
    public PageInfo<MovieVO> queryMovieByCategory(Long categoryId, Integer offset, Integer count) throws ApiException {

        PageHelper.offsetPage(offset, count);
        List<MovieCategory> movieCategories = movieCategoryMapper.selectByCategory(categoryId);
        List<MovieVO> voList = new ArrayList<>();

        // 查询当前类别下的所有电影
        for (MovieCategory mc : movieCategories) {
            voList.add(movieService.queryById(mc.getMovieId(),true));
        }

        return new PageInfo<>(voList);
    }
}
