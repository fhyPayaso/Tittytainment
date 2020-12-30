package com.fhypayaso.tittytainment.modules.security.service.impl;

import com.fhypayaso.tittytainment.dao.UserMapper;
import com.fhypayaso.tittytainment.exception.AccountLockedException;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.dto.JwtUser;
import com.fhypayaso.tittytainment.modules.security.service.SecurityDetailsService;
import com.fhypayaso.tittytainment.pojo.entity.Role;
import com.fhypayaso.tittytainment.pojo.entity.User;
import com.fhypayaso.tittytainment.pojo.entity.UserRole;
import com.fhypayaso.tittytainment.modules.security.service.RoleService;
import com.fhypayaso.tittytainment.modules.security.service.UserRoleService;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/27 12:17 上午
#   @Description   : 
# ====================================================*/
@Service
public class SecurityDetailServiceImpl implements SecurityDetailsService {


    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        // 首先查询当前用户
        User user = userMapper.selectByPhone(phone);

        // 获取当前用户对应角色列表
        List<Role> roleList = queryRolesByUser(user);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roleList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
            grantedAuthorities.add(grantedAuthority);
        }


        JwtUser detail = new JwtUser();
        detail.setUser(user);
        detail.setAuthorityList(grantedAuthorities);
        return detail;
    }


    private List<Role> queryRolesByUser(User user) {

        // 然后查询当前用户拥有哪些角色
        List<UserRole> userRoleList = userRoleService.getAllUserRoleByUid(user.getId());
        // 根据角色id查询到真正的角色列表
        List<Role> roleList = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            roleList.add(roleService.queryById(userRole.getRoleId()));
        }
        return roleList;
    }
}
