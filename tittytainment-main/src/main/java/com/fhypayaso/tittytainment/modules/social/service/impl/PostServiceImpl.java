package com.fhypayaso.tittytainment.modules.social.service.impl;

import com.fhypayaso.tittytainment.dao.MovieMapper;
import com.fhypayaso.tittytainment.dao.PostMapper;
import com.fhypayaso.tittytainment.dao.TopicMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.service.UserService;
import com.fhypayaso.tittytainment.modules.social.config.PostType;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostParam;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostVO;
import com.fhypayaso.tittytainment.modules.social.service.CommentService;
import com.fhypayaso.tittytainment.modules.social.service.PostService;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.Post;
import com.fhypayaso.tittytainment.pojo.entity.Topic;
import com.fhypayaso.tittytainment.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
public class PostServiceImpl implements PostService {

    @Resource
    private PostMapper postMapper;

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private UserService userService;

    @Resource
    private MovieMapper movieMapper;

    @Resource
    private CommentService commentService;


    @Override
    public void createPost(PostParam param) throws ApiException {

        Topic topic = topicMapper.selectByPrimaryKey(param.getTopicId());
        ApiException.when(topic == null, "主题不存在");


        // 电影默认帖子
        if (PostType.MOVIE.check(param.getPostType())) {

            Movie movie = movieMapper.selectByPrimaryKey(param.getMovieId());
            ApiException.when(movie == null, "电影不存在");
        }

        Post post = new Post();
        BeanUtils.copyProperties(param, post);
        Long uid = userService.currentUserId();
        post.setCreateUserId(uid);
        post.setLastCommentTime(DateUtil.currentDate());
        post.setCreatedTime(DateUtil.currentDate());
        post.setUpdatedTime(DateUtil.currentDate());

        ApiException.when(postMapper.insert(post) == 0, "发帖失败");
    }

    @Override
    public void updatePost(PostParam param) throws ApiException {

        Post post = postMapper.selectByPrimaryKey(param.getId());
        ApiException.when(post == null, "帖子不存在");

        post.setTitle(param.getTitle());
        post.setContent(param.getContent());
        post.setUpdatedTime(DateUtil.currentDate());

        ApiException.when(postMapper.updateByPrimaryKey(post) == 0, "更新失败");
    }

    @Override
    public PageInfo<PostVO> queryAllByTopic(Long topicId, Integer offset, Integer count) throws ApiException {
        Topic topic = topicMapper.selectByPrimaryKey(topicId);
        return queryPagePost(topic, offset, count);
    }

    @Override
    public PageInfo<PostVO> queryAllByMovie(Long movieId, Integer offset, Integer count) throws ApiException {
        Topic topic = topicMapper.selectByMovie(movieId);
        return queryPagePost(topic, offset, count);
    }

    @Override
    public void deletePost(Long postId) throws ApiException {

        Post post = postMapper.selectByPrimaryKey(postId);
        ApiException.when(post == null, "帖子不存在");
        Long uid = userService.currentUserId();
        ApiException.when(!uid.equals(post.getCreateUserId()), "没有删除权限");

        // 删除帖子下的全部评论
        commentService.deleteCommentByPost(postId);
        ApiException.when(postMapper.deleteByPrimaryKey(postId) == 0, "删除失败");
    }

    @Override
    public void deletePostsByTopic(Long topicId) throws ApiException {

        List<Post> postList = postMapper.selectByTopic(topicId);
        for (Post post : postList) {
            commentService.deleteCommentByPost(post.getId());
        }
        postMapper.deleteAllPostByTopic(topicId);
    }

    private PageInfo<PostVO> queryPagePost(Topic topic, Integer offset, Integer count) throws ApiException {
        ApiException.when(topic == null, "主题不存在");

        PageHelper.offsetPage(offset, count);
        List<Post> postList = postMapper.selectByTopic(topic.getId());

        List<PostVO> voList = postList.stream()
                .map(post -> {
                    PostVO vo = new PostVO();
                    BeanUtils.copyProperties(post, vo);
                    return vo;
                })
                .collect(Collectors.toList());

        return new PageInfo<>(voList);
    }


}
