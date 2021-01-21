package com.fhypayaso.tittytainment.modules.social.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.modules.social.dto.like.LikeParam;
import com.fhypayaso.tittytainment.modules.social.service.LikeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:52 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/bbs")
public class LikeController {

    @Resource
    private LikeService likeService;


    @PostMapping("/like")
    public CommonResult<Void> clickLike(@RequestBody LikeParam param) {
        likeService.clickLike(param);
        return CommonResult.success("点赞成功");
    }

    @PostMapping("/unlike")
    public CommonResult<Void> cancelLike(@RequestBody LikeParam param) {
        likeService.cancelLike(param);
        return CommonResult.success("取消点赞成功");
    }

}
