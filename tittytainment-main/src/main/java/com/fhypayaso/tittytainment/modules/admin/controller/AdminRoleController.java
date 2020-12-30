package com.fhypayaso.tittytainment.modules.admin.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.admin.dto.UserRoleVO;
import com.fhypayaso.tittytainment.modules.security.service.UserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/30 12:07 下午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("admin/")
public class AdminRoleController {

    @Resource
    private UserRoleService userRoleService;

    @PostMapping("user/addRole")
    @ApiOperation(value = "插入用户-角色关系")
    public CommonResult insert(@RequestBody UserRoleVO userRoleVO) throws ApiException {
        userRoleService.insert(userRoleVO.getUserId(), userRoleVO.getRoleId());
        return CommonResult.success("关系插入成功");
    }
}
