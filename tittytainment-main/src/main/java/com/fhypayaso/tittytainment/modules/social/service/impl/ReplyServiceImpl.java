package com.fhypayaso.tittytainment.modules.social.service.impl;

import com.fhypayaso.tittytainment.dao.CommentMapper;
import com.fhypayaso.tittytainment.dao.PostMapper;
import com.fhypayaso.tittytainment.dao.ReplyMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.service.UserService;
import com.fhypayaso.tittytainment.modules.social.config.ReplyType;
import com.fhypayaso.tittytainment.modules.social.dto.reply.ReplyParam;
import com.fhypayaso.tittytainment.modules.social.dto.reply.ReplyVO;
import com.fhypayaso.tittytainment.modules.social.service.ReplyService;
import com.fhypayaso.tittytainment.pojo.entity.Comment;
import com.fhypayaso.tittytainment.pojo.entity.Post;
import com.fhypayaso.tittytainment.pojo.entity.Reply;
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
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private UserService userService;

    @Resource
    private ReplyMapper replyMapper;


    @Resource
    private CommentMapper commentMapper;

    @Resource
    private PostMapper postMapper;


    @Override
    public void replyToComment(ReplyParam param) throws ApiException {

        Reply reply = replyMapper.selectByPrimaryKey(param.getId());
        ApiException.when(reply != null, "当前回复已存在");

        reply = new Reply();

        // 每个回复都挂在一个评论下
        Comment comment = commentMapper.selectByPrimaryKey(param.getCommentId());
        ApiException.when(comment == null, "回复的评论不存在");
        reply.setReplyType(param.getReplyType());
        reply.setCommentId(param.getCommentId());

        if (ReplyType.TO_REPLY.check(param.getReplyType())) {
            // 回复某条回复
            Reply originReply = replyMapper.selectByPrimaryKey(param.getReplyId());
            ApiException.when(originReply == null, "回复的回复不存在");
            reply.setReplyId(param.getReplyId());
        }

        reply.setStatus(true);
        reply.setReplyUserId(param.getReplyUserId());
        reply.setUserId(userService.currentUserId());
        reply.setCreatedTime(DateUtil.currentDate());
        reply.setUpdatedTime(DateUtil.currentDate());
        ApiException.when(replyMapper.insert(reply) == 0, "添加评论失败");
    }

    @Override
    public PageInfo<ReplyVO> queryRepliesByComment(Long commentId, Integer offset, Integer count) throws ApiException {

        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        ApiException.when(comment == null, "评论不存在");

        PageHelper.offsetPage(offset, count);
        List<Reply> list = replyMapper.selectByComment(commentId);

        List<ReplyVO> voList = list.stream()
                .map(reply -> {
                    ReplyVO vo = new ReplyVO();
                    BeanUtils.copyProperties(reply, vo);
                    return vo;
                })
                .collect(Collectors.toList());
        return new PageInfo<>(voList);
    }


    @Override
    public void deleteReply(Long replyId) throws ApiException {

        Reply reply = replyMapper.selectByPrimaryKey(replyId);
        ApiException.when(reply == null, "回复不存在");

        // 判断当前是否有权删除
        Long uid = userService.currentUserId();

        // 发表当前评论的用户
        Comment comment = commentMapper.selectByPrimaryKey(reply.getCommentId());
        ApiException.when(comment == null, "评论不存在");

        // 发表帖子的用户
        Post post = postMapper.selectByPrimaryKey(comment.getPostId());
        ApiException.when(post == null, "帖子不存在");

        if (uid.equals(reply.getUserId()) || uid.equals(comment.getUserId()) || uid.equals(post.getCreateUserId())) {
            ApiException.when(replyMapper.deleteByPrimaryKey(replyId) == 0, "删除失败");
        }

        throw new ApiException("无删除权限");
    }


    @Override
    public void deleteReplyByComment(Long commentId) throws ApiException {
        replyMapper.deleteByComment(commentId);
    }

}
