package com.fhypayaso.tittytainment.modules.social.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.comment.CommentParam;
import com.fhypayaso.tittytainment.modules.social.dto.comment.CommentVO;
import com.fhypayaso.tittytainment.pojo.entity.Comment;
import com.github.pagehelper.PageInfo;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:47 上午
#   @Description   : 
# ====================================================*/
public interface CommentService {


    void createComment(CommentParam param) throws ApiException;

    PageInfo<CommentVO> queryComments(Long postId, Integer offset, Integer count)throws ApiException;


    void deleteComment(Long commentId) throws ApiException;


    void deleteCommentByPost(Long postId) throws ApiException;





}
