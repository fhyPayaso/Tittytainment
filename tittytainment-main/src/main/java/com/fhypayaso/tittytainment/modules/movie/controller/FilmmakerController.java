package com.fhypayaso.tittytainment.modules.movie.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.filmmaker.FilmmakerVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.service.FilmmakerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/7 4:11 下午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/filmmaker")
public class FilmmakerController {


    @Resource
    private FilmmakerService filmmakerService;


    @GetMapping("/info/{id}")
    @ApiOperation("获取指定演员的信息")
    CommonResult<FilmmakerVO> queryFilmmakerById(@PathVariable("id") Long id) throws ApiException {
        FilmmakerVO vo = filmmakerService.queryById(id, true);
        return CommonResult.success(vo, "演员信息查询成功");
    }


    @GetMapping("/movies")
    @ApiOperation("获取当前演员的全部电影")
    CommonResult<PageInfo<MovieVO>> queryMovieListByActor(@RequestParam("filmmaker_id") Long filmmakerId,
                                                          @RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                                          @RequestParam(name = "count", defaultValue = "20") Integer count) throws ApiException {
        PageInfo<MovieVO> list = filmmakerService.queryMoviesByFilmmaker(filmmakerId, offset, count);
        return CommonResult.success(list, "查询成功");
    }


}
