package com.fhypayaso.tittytainment.modules.security.service.impl;

import com.fhypayaso.tittytainment.dao.UserMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.service.SmsService;
import com.fhypayaso.tittytainment.modules.security.util.RedisUtil;
import com.fhypayaso.tittytainment.modules.security.util.SmsUtil;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 9:13 下午
#   @Description   : 
# ====================================================*/
@Service
public class SmsServiceImpl implements SmsService {


    @Value("${sms.expiration}")
    private Long expiration;

    @Resource
    private SmsUtil smsUtil;


    @Resource
    private RedisUtil redisUtil;


    @Override
    public Boolean sendMessage(String phone) throws TencentCloudSDKException, ApiException {

        // 生成验证码
        String captcha = smsUtil.generateCaptchaCode();
        // 验证码存入redis, 并设置验证码有效时间
        redisUtil.setValueAndExpire(phone, captcha, expiration * 60);
        // 发送验证码
        return smsUtil.sendMessage(phone, captcha);
    }


}
