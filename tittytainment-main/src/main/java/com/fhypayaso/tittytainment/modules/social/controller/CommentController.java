package com.fhypayaso.tittytainment.modules.social.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.comment.CommentParam;
import com.fhypayaso.tittytainment.modules.social.dto.comment.CommentVO;
import com.fhypayaso.tittytainment.modules.social.service.CommentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:51 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/bbs/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    @PostMapping("/create")
    @ApiOperation("创建评论")
    CommonResult<Void> createComment(@RequestBody CommentParam param) throws ApiException {
        commentService.createComment(param);
        return CommonResult.success("添加评论成功");
    }

    @GetMapping("/list")
    @ApiOperation("分页获取帖子下的全部评论")
    CommonResult<PageInfo<CommentVO>> queryCommentsByPost(@RequestParam("post_id") Long postId,
                                                          @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                          @RequestParam(value = "count", defaultValue = "20") Integer count) throws ApiException {

        PageInfo<CommentVO> pageInfo = commentService.queryComments(postId, offset, count);
        return CommonResult.success(pageInfo, "评论列表查询成功");
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除某条评论")
    CommonResult<Void> deleteById(@PathVariable("id") Long commentId) throws ApiException {
        commentService.deleteComment(commentId);
        return CommonResult.success("删除成功");
    }


}
