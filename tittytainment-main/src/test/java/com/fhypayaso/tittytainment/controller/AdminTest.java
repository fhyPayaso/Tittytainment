package com.fhypayaso.tittytainment.controller;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.service.UserRoleService;
import com.fhypayaso.tittytainment.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 12:58 上午
#   @Description   : 
# ====================================================*/
@Slf4j
public class AdminTest {


    @Resource
    private UserRoleService userRoleService;


    @Test
    public void insert() throws ApiException {

        Date date = DateUtil.formatStr2Date("yyyy/MM/dd", "2000/10/01");
        System.out.println(date);


//        userRoleService.insert(3, 1);
//        userRoleService.insert(3, 2);
//        userRoleService.insert(4, 2);


    }


}
