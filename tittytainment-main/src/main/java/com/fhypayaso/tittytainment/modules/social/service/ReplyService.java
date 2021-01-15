package com.fhypayaso.tittytainment.modules.social.service;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:47 上午
#   @Description   : 
# ====================================================*/

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.reply.ReplyParam;
import com.fhypayaso.tittytainment.modules.social.dto.reply.ReplyVO;
import com.fhypayaso.tittytainment.pojo.entity.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ReplyService {


    void replyToComment(ReplyParam param) throws ApiException;


    PageInfo<ReplyVO> queryRepliesByComment(Long commentId, Integer offset, Integer count) throws ApiException;


    void deleteReply(Long replyId) throws ApiException;


    void deleteReplyByComment(Long commentId) throws ApiException;


}
