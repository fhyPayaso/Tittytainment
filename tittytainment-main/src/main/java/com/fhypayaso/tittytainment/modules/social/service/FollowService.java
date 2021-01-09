package com.fhypayaso.tittytainment.modules.social.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.dto.vo.UserVO;
import com.github.pagehelper.PageInfo;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/7 10:39 下午
#   @Description   : 
# ====================================================*/
public interface FollowService {


    void followOther(Long followUserId) throws ApiException;

    void cancelFollowOther(Long followUserId) throws ApiException;


    PageInfo<UserVO> queryFollowingUsers(Integer offset, Integer count) throws ApiException;

    PageInfo<UserVO> queryFollowedUsers(Integer offset, Integer count) throws ApiException;

}
