package com.fhypayaso.tittytainment.modules.social.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostParam;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostVO;
import com.fhypayaso.tittytainment.modules.social.service.PostService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:52 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/bbs/post")
public class PostController {

    @Resource
    private PostService postService;




    @PostMapping("/create")
    @ApiOperation("发表帖子")
    CommonResult<Void> createPost(@RequestBody PostParam param) throws ApiException {
        postService.createPost(param);
        return CommonResult.success("帖子发表成功");
    }

    @PostMapping("/update")
    @ApiOperation("更新帖子内容")
    CommonResult<Void> update(@RequestBody PostParam param) throws ApiException {
        postService.updatePost(param);
        return CommonResult.success("帖子更新成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除帖子")
    CommonResult<Void> deletePost(@PathVariable("id") Long postId) throws ApiException {
        postService.deletePost(postId);
        return CommonResult.success("删除成功");
    }


    @GetMapping("/topic/list")
    @ApiOperation("获取一个主题下的全部帖子")
    CommonResult<PageInfo<PostVO>> queryPostsByTopic(@RequestParam("topic_id") Long topicId,
                                                     @RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                                     @RequestParam(name = "count", defaultValue = "20") Integer count) throws ApiException {
        PageInfo<PostVO> voPageInfo = postService.queryAllByTopic(topicId, offset, count);
        return CommonResult.success(voPageInfo, "查询成功");
    }


    @GetMapping("/movie/list")
    @ApiOperation("获取一个电影下的全部帖子")
    CommonResult<PageInfo<PostVO>> queryPostsByMovie(@RequestParam("movie_id") Long movieId,
                                                     @RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                                     @RequestParam(name = "count", defaultValue = "20") Integer count) throws ApiException {
        PageInfo<PostVO> voPageInfo = postService.queryAllByMovie(movieId, offset, count);
        return CommonResult.success(voPageInfo, "查询成功");
    }


}
