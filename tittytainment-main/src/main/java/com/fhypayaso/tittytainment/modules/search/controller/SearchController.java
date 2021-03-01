package com.fhypayaso.tittytainment.modules.search.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.search.pojo.SearchVO;
import com.fhypayaso.tittytainment.modules.search.service.SearchService;
import com.fhypayaso.tittytainment.modules.security.dto.vo.UserVO;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 10:46 上午
#   @Description   : 搜索接口，通过ES实现全局搜索
# ====================================================*/
@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private SearchService searchService;


    @GetMapping("/all")
    @ApiOperation("全局聚合搜索")
    CommonResult<SearchVO> searchFromAll(@RequestParam("keyword") String keyword,
                                         @RequestParam(value = "count", defaultValue = "5") Integer count) {
        SearchVO vo = searchService.unionSearch(keyword, count);
        return CommonResult.success(vo);
    }

    @GetMapping("/movie")
    @ApiOperation("电影搜索")
    CommonResult<PageInfo<MovieVO>> searchMovie(@RequestParam("keyword") String keyword,
                                                @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                @RequestParam(value = "count", defaultValue = "20") Integer count) {
        PageInfo<MovieVO> pageInfo = searchService.movieSearch(keyword, offset, count);
        return CommonResult.success(pageInfo);
    }

    @GetMapping("/post")
    @ApiOperation("帖子搜索")
    CommonResult<PageInfo<PostVO>> searchPost(@RequestParam("keyword") String keyword,
                                                @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                @RequestParam(value = "count", defaultValue = "20") Integer count) {
        PageInfo<PostVO> pageInfo = searchService.postSearch(keyword, offset, count);
        return CommonResult.success(pageInfo);
    }


    @GetMapping("/user")
    @ApiOperation("用户搜索")
    CommonResult<PageInfo<UserVO>> searchUser(@RequestParam("keyword") String keyword,
                                              @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                              @RequestParam(value = "count", defaultValue = "20") Integer count) {
        PageInfo<UserVO> pageInfo = searchService.userSearch(keyword, offset, count);
        return CommonResult.success(pageInfo);
    }


}
