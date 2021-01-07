package com.fhypayaso.tittytainment.modules.movie.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.language.LanguageVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.service.LanguageService;
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
#   @Date          : 2021/1/7 12:11 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/language")
public class LanguageController {


    @Resource
    private LanguageService languageService;


    @GetMapping("/all")
    @ApiOperation("获取全部语言")
    CommonResult<List<LanguageVO>> queryAll() {
        List<LanguageVO> voList = languageService.queryAll();
        return CommonResult.success(voList, "查询成功");
    }

    @GetMapping("/movie")
    @ApiOperation("分页查询当前语言下全部电影")
    CommonResult<PageInfo<MovieVO>> queryMoviePageByLanguage(@RequestParam("language_id") Long languageId,
                                                             @RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                                             @RequestParam(name = "count", defaultValue = "20") Integer count) throws ApiException {

        PageInfo<MovieVO> voPage = languageService.queryMovieByLanguage(
                languageId, offset, count);
        return CommonResult.success(voPage, "查询成功");
    }



}
