package com.fhypayaso.tittytainment.controller;


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;

import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 4:54 下午
#   @Description   : 
# ====================================================*/
@Slf4j
class UserControllerTest {


    @Test
    void logTest() {
        log.debug("debug-----------------");
        log.info("info-----------------");
        log.error("error--------------");
    }


    @Test
    void register() {
    }

    @Test
    void login() {
    }

    @Test
    void captan() {



    }


}