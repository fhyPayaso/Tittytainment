package com.fhypayaso.tittytainment.modules.security.service.impl;

import com.fhypayaso.tittytainment.dao.RoleMapper;
import com.fhypayaso.tittytainment.dao.UserMapper;
import com.fhypayaso.tittytainment.dao.UserRoleMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.pojo.entity.Role;
import com.fhypayaso.tittytainment.pojo.entity.User;
import com.fhypayaso.tittytainment.pojo.entity.UserRole;
import com.fhypayaso.tittytainment.modules.security.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/27 1:49 上午
#   @Description   : 
# ====================================================*/
@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {


    @Resource
    private UserRoleMapper userRoleMapper;


    @Resource
    private UserMapper userMapper;


    @Resource
    private RoleMapper roleMapper;


    public List<UserRole> getAllUserRoleByUid(Integer uid) {
        return userRoleMapper.selectByUid(uid);
    }

    @Override
    public int deleteByUid(Integer uid) {
        return userRoleMapper.deleteByUid(uid);
    }


    public int insert(Integer uid, Integer rid) throws ApiException {

        User user = userMapper.selectByPrimaryKey(uid);
        ApiException.when(user == null, "用户不存在");

        Role role = roleMapper.selectByPrimaryKey(rid);
        ApiException.when(role == null, "角色不存在");

        ApiException.when(userRoleMapper.selectByPrimaryKey(uid, rid) != null, "该关系已存在");

        UserRole userRole = new UserRole();
        userRole.setUserId(uid);
        userRole.setRoleId(rid);
        return userRoleMapper.insert(userRole);
    }


}
