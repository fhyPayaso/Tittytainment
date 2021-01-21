package com.fhypayaso.tittytainment.modules.social.service;

import com.fhypayaso.tittytainment.modules.social.dto.like.LikeNumDTO;
import com.fhypayaso.tittytainment.modules.social.dto.like.LikeParam;
import com.fhypayaso.tittytainment.pojo.entity.Like;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:48 上午
#   @Description   : 
# ====================================================*/
public interface LikeService {


    void clickLike(LikeParam param);

    void cancelLike(LikeParam param);

    Long queryPostLikeNum(Long id);

    Long queryCommentLikeNum(Long id);

    List<Like> parseLikeCache();

    List<LikeNumDTO> parseLikeNumCache();

}
