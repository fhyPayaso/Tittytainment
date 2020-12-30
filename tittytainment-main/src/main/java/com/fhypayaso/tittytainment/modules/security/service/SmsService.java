package com.fhypayaso.tittytainment.modules.security.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 9:12 下午
#   @Description   : 短信验证码
# ====================================================*/
public interface SmsService {


    Boolean sendMessage(String phone) throws TencentCloudSDKException, ApiException;

}
