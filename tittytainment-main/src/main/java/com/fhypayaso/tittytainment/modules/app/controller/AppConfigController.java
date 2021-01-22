package com.fhypayaso.tittytainment.modules.app.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.app.pojo.AppConfigDTO;
import com.fhypayaso.tittytainment.modules.app.pojo.AppConfigVO;
import com.fhypayaso.tittytainment.modules.app.service.AppConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 8:10 下午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/config")
public class AppConfigController {


    @Resource
    private AppConfigService appConfigService;


    @PostMapping("/create")
    @ApiOperation("创建新版本")
    CommonResult<Void> createVersionConfig(@RequestBody AppConfigDTO dto) throws ApiException {
        appConfigService.createVersionConfig(dto);
        return CommonResult.success("创建版本信息成功");
    }

    @GetMapping("/last")
    @ApiOperation("获取最新版本")
    CommonResult<AppConfigVO> lastVersion() {
        return CommonResult.success(appConfigService.lastVersion(), "查询成功");
    }


    @GetMapping("/list")
    @ApiOperation("获取全部版本信息")
    CommonResult<List<AppConfigVO>> allVersions() {
        List<AppConfigVO> voList = appConfigService.queryAllVersion();
        return CommonResult.success(voList, "查询成功");
    }


}
