package com.fhypayaso.tittytainment.modules.security.service.impl;

import com.fhypayaso.tittytainment.dao.RoleMapper;
import com.fhypayaso.tittytainment.pojo.entity.Role;
import com.fhypayaso.tittytainment.modules.security.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/27 1:44 上午
#   @Description   : 
# ====================================================*/
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    @Override
    public Role queryById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
