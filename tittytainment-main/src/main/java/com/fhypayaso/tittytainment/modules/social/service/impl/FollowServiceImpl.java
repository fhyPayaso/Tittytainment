package com.fhypayaso.tittytainment.modules.social.service.impl;

import com.fhypayaso.tittytainment.dao.UserFollowMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.dto.vo.UserVO;
import com.fhypayaso.tittytainment.modules.security.service.UserService;
import com.fhypayaso.tittytainment.modules.social.service.FollowService;
import com.fhypayaso.tittytainment.pojo.entity.UserFollow;
import com.fhypayaso.tittytainment.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/7 10:40 下午
#   @Description   : 
# ====================================================*/
@Service
@Slf4j
public class FollowServiceImpl implements FollowService {


    @Resource
    private UserFollowMapper userFollowMapper;

    @Resource
    private UserService userService;


    @Override
    public void followOther(Long followUserId) throws ApiException {

        Long uid = userService.currentUserId();

        UserFollow userFollow = userFollowMapper.selectByUids(uid, followUserId);

        if (userFollow == null) {
            userFollow = new UserFollow();
            userFollow.setUserId(uid);
            userFollow.setFollowUserId(followUserId);
            userFollow.setCreatedTime(DateUtil.currentDate());
        }

        userFollow.setFollow(true);
        userFollow.setUpdatedTime(DateUtil.currentDate());

        ApiException.when(userFollowMapper.insert(userFollow) == 0, "关注失败");
    }

    @Override
    public void cancelFollowOther(Long followUserId) throws ApiException {

        Long uid = userService.currentUserId();
        UserFollow userFollow = userFollowMapper.selectByUids(uid, followUserId);
        ApiException.when(userFollow == null, "未关注当前用户");

        userFollow.setFollow(false);
        userFollow.setUpdatedTime(DateUtil.currentDate());
        ApiException.when(userFollowMapper.updateByPrimaryKey(userFollow) == 0, "取消关注失败");
    }

    @Override
    public PageInfo<UserVO> queryFollowingUsers(Integer offset, Integer count) throws ApiException {

        Long uid = userService.currentUserId();

        PageHelper.offsetPage(offset, count);
        List<UserFollow> userFollows = userFollowMapper.selectFollowingList(uid);

        List<UserVO> voList = new ArrayList<>();

        for (UserFollow uf : userFollows) {
            UserVO vo = userService.getUserInfoById(Math.toIntExact(uf.getFollowUserId()));
            voList.add(vo);
        }

        return new PageInfo<>(voList);
    }

    @Override
    public PageInfo<UserVO> queryFollowedUsers(Integer offset, Integer count) throws ApiException {

        Long uid = userService.currentUserId();
        PageHelper.offsetPage(offset, count);

        List<UserFollow> userFollows = userFollowMapper.selectFollowedList(uid);
        List<UserVO> voList = new ArrayList<>();

        for (UserFollow uf : userFollows) {
            UserVO vo = userService.getUserInfoById(Math.toIntExact(uf.getUserId()));
            voList.add(vo);
        }

        return new PageInfo<>(voList);
    }
}
