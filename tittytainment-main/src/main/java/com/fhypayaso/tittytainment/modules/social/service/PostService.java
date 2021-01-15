package com.fhypayaso.tittytainment.modules.social.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostParam;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostVO;
import com.github.pagehelper.PageInfo;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:46 上午
#   @Description   : 帖子
# ====================================================*/
public interface PostService {


    void createPost(PostParam param) throws ApiException;

    void updatePost(PostParam param) throws ApiException;

    PageInfo<PostVO> queryAllByTopic(Long topicId, Integer offset, Integer count) throws ApiException;

    PageInfo<PostVO> queryAllByMovie(Long movieId, Integer offset, Integer count) throws ApiException;

    void deletePost(Long postId) throws ApiException;

    void deletePostsByTopic(Long topicId) throws ApiException;

}
