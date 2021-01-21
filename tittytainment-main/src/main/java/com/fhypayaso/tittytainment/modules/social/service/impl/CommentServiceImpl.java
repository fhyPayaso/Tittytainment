package com.fhypayaso.tittytainment.modules.social.service.impl;

import com.fhypayaso.tittytainment.dao.CommentMapper;
import com.fhypayaso.tittytainment.dao.PostMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.service.UserService;
import com.fhypayaso.tittytainment.modules.social.dto.comment.CommentParam;
import com.fhypayaso.tittytainment.modules.social.dto.comment.CommentVO;
import com.fhypayaso.tittytainment.modules.social.service.CommentService;
import com.fhypayaso.tittytainment.modules.social.service.LikeService;
import com.fhypayaso.tittytainment.modules.social.service.ReplyService;
import com.fhypayaso.tittytainment.pojo.entity.Comment;
import com.fhypayaso.tittytainment.pojo.entity.Post;
import com.fhypayaso.tittytainment.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:49 上午
#   @Description   : 
# ====================================================*/
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private PostMapper postMapper;

    @Resource
    private UserService userService;

    @Resource
    private ReplyService replyService;

    @Resource
    private LikeService likeService;


    @Override
    public void createComment(CommentParam param) throws ApiException {

        Post post = postMapper.selectByPrimaryKey(param.getPostId());
        ApiException.when(post == null, "当前帖子不存在");


        Comment comment = new Comment();
        comment.setPostId(param.getPostId());
        comment.setContent(param.getContent());
        Long uid = userService.currentUserId();
        comment.setUserId(uid);
        comment.setStatus(true);
        comment.setLikeNum(0L);
        comment.setReplyNum(0L);
        comment.setCreatedTime(DateUtil.currentDate());
        comment.setUpdatedTime(DateUtil.currentDate());

        commentMapper.insert(comment);

        // 添加评论数量
        post.setCommentNum(post.getCommentNum() + 1);
        postMapper.updateByPrimaryKey(post);
    }

    @Override
    public PageInfo<CommentVO> queryComments(Long postId, Integer offset, Integer count) throws ApiException {

        Post post = postMapper.selectByPrimaryKey(postId);
        ApiException.when(post == null, "当前帖子不存在");

        PageHelper.offsetPage(offset, count);
        List<Comment> comments = commentMapper.selectByPost(postId);

        List<CommentVO> voList = comments.stream()
                .filter(Comment::getStatus)
                .map(comment -> {
                    CommentVO vo = new CommentVO();
                    BeanUtils.copyProperties(comment, vo);
                    vo.setLikeNum(likeService.queryCommentLikeNum(comment.getId()));
                    return vo;
                })
                .collect(Collectors.toList());
        return new PageInfo<>(voList);
    }

    @Override
    public void deleteComment(Long commentId) throws ApiException {

        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        ApiException.when(comment == null, "评论不存在");
        // 先删除评论下的全部回复
        replyService.deleteReplyByComment(commentId);
        ApiException.when(commentMapper.deleteByPrimaryKey(commentId) == 0, "删除失败");


    }

    @Override
    public void deleteCommentByPost(Long postId) throws ApiException {

        List<Comment> comments = commentMapper.selectByPost(postId);
        for (Comment comment : comments) {
            replyService.deleteReplyByComment(comment.getId());
        }
        commentMapper.deleteByPostId(postId);

    }
}
