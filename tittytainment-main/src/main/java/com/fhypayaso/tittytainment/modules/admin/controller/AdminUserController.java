package com.fhypayaso.tittytainment.modules.admin.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.admin.dto.UserRoleVO;
import com.fhypayaso.tittytainment.modules.security.service.UserService;
import com.fhypayaso.tittytainment.modules.security.service.UserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 12:46 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("admin/")
public class AdminUserController {

    @Resource
    private UserService userService;


    @DeleteMapping("user/delete/{id}")
    @ApiOperation(value = "删除用户")
    public CommonResult deleteUserById(@PathVariable("id") Integer id) throws ApiException {
        userService.deleteUserById(id);
        return CommonResult.success("删除成功");
    }


    @GetMapping("user/lock/{id}")
    @ApiOperation(value = "锁定用户账号")
    public CommonResult lockUserById(@PathVariable("id") Integer id) throws ApiException {
        userService.lockByUid(id);
        return CommonResult.success("账号锁定成功");
    }


    @GetMapping("user/unlock/{id}")
    @ApiOperation(value = "解除账号锁定")
    public CommonResult unlockUserById(@PathVariable("id") Integer id) throws ApiException {
        userService.unlockByUid(id);
        return CommonResult.success("账号解锁成功");
    }

}
