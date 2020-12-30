package com.fhypayaso.tittytainment.modules.security.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.pojo.entity.UserRole;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/27 1:44 上午
#   @Description   : 
# ====================================================*/
public interface UserRoleService {

    List<UserRole> getAllUserRoleByUid(Integer uid);

    int deleteByUid(Integer uid);

    int insert(Integer uid, Integer rid) throws ApiException;
}
