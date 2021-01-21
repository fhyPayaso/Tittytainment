package com.fhypayaso.tittytainment.modules.social.task;

import com.fhypayaso.tittytainment.dao.CommentMapper;
import com.fhypayaso.tittytainment.dao.LikeMapper;
import com.fhypayaso.tittytainment.dao.PostMapper;
import com.fhypayaso.tittytainment.modules.security.util.RedisUtil;
import com.fhypayaso.tittytainment.modules.social.config.LikeType;
import com.fhypayaso.tittytainment.modules.social.dto.like.LikeNumDTO;
import com.fhypayaso.tittytainment.modules.social.service.LikeService;
import com.fhypayaso.tittytainment.pojo.entity.Comment;
import com.fhypayaso.tittytainment.pojo.entity.Like;
import com.fhypayaso.tittytainment.pojo.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/17 2:30 上午
#   @Description   : 定时任务，保持redis和mysql数据一致
# ====================================================*/
@Slf4j
public class LikeTask extends QuartzJobBean {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private LikeService likeService;

    @Resource
    private LikeMapper likeMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private PostMapper postMapper;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        syncLikeData();
        syncLikeNumData();
    }


    private void syncLikeData() {

        List<Like> likeList = likeService.parseLikeCache();

        for (Like like : likeList) {

            Like originLike = null;

            if (LikeType.COMMENT.check(like.getType())) {
                originLike = likeMapper.selectByCommentId(like.getUserId(), like.getCommentId());
            } else if (LikeType.POST.check(like.getType())) {
                originLike = likeMapper.selectByPostId(like.getUserId(), like.getPostId());
            }

            if (originLike == null) {
                likeMapper.insert(like);
            } else {
                originLike.setStatus(like.getStatus());
                originLike.setUpdatedTime(like.getUpdatedTime());
                likeMapper.updateByPrimaryKey(originLike);
            }

        }


    }


    private void syncLikeNumData() {

        List<LikeNumDTO> dtoList = likeService.parseLikeNumCache();
        for (LikeNumDTO dto : dtoList) {

            if (LikeType.COMMENT.check(dto.getType())) {

                Comment comment = commentMapper.selectByPrimaryKey(dto.getCommentId());
                comment.setLikeNum(dto.getLikeNum());
                commentMapper.updateByPrimaryKey(comment);

            } else if (LikeType.POST.check(dto.getType())) {

                Post post = postMapper.selectByPrimaryKey(dto.getPostId());
                post.setLikeNum(dto.getLikeNum());
                postMapper.updateByPrimaryKey(post);

            }
        }

    }

}
