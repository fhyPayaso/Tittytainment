package com.fhypayaso.tittytainment.modules.movie.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.category.CategoryVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.service.CategoryService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/6 11:57 下午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/category")
public class CategoryController {


    @Resource
    private CategoryService categoryService;


    @GetMapping("/all")
    @ApiOperation("查询全部分类")
    CommonResult<List<CategoryVO>> queryAll() {

        List<CategoryVO> list = categoryService.queryAll();
        return CommonResult.success(list, "查询成功");
    }

    @GetMapping("/movie")
    @ApiOperation("分页查询当前分类下全部电影")
    CommonResult<PageInfo<MovieVO>> queryMoviePageByCategory(@RequestParam("category_id") Long categoryId,
                                                             @RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                                             @RequestParam(name = "count", defaultValue = "20") Integer count) throws ApiException {

        PageInfo<MovieVO> voPage = categoryService.queryMovieByCategory(
                categoryId, offset, count);
        return CommonResult.success(voPage, "查询成功");
    }


}
