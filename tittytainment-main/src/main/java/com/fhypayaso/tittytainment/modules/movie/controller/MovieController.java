package com.fhypayaso.tittytainment.modules.movie.controller;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 1:14 上午
#   @Description   : 
# ====================================================*/

import com.fhypayaso.tittytainment.modules.movie.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("movie/")
public class MovieController {


    @Resource
    MovieService movieService;


//
//    @GetMapping("query/{id}")
//    CommonResult<Movie> query(@PathVariable("id")Integer id) {
//        Movie movie = movieService.queryById(id);
//        return new CommonResult.success(movie);
//    }






}
