package com.fhypayaso.tittytainment.modules.movie.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.dto.region.RegionVO;
import com.fhypayaso.tittytainment.modules.movie.service.RegionService;
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
#   @Date          : 2021/1/7 12:17 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/region")
public class RegionController {


    @Resource
    private RegionService regionService;


    @GetMapping("/all")
    @ApiOperation("获取全部地区")
    CommonResult<List<RegionVO>> queryAll() {

        List<RegionVO> voList = regionService.queryAll();

        return CommonResult.success(voList, "查询成功");
    }

    @GetMapping("/movie")
    @ApiOperation("分页查询地区分类下全部电影")
    CommonResult<PageInfo<MovieVO>> queryMoviePageByRegion(@RequestParam("region_id") Long regionId,
                                                           @RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                                           @RequestParam(name = "count", defaultValue = "20") Integer count) throws ApiException {

        PageInfo<MovieVO> voPage = regionService.queryMovieByRegion(regionId, offset, count);
        return CommonResult.success(voPage, "查询成功");
    }


}
