package com.fhypayaso.tittytainment.modules.security.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.security.dto.vo.*;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 1:04 上午
#   @Description   : 
# ====================================================*/
public interface UserService {


    String register(RegisterVO registerVO) throws ApiException;

    String loginByPhone(LoginVO loginVO) throws ApiException;

    String loginBySms(LoginSmsVO loginSmsVO) throws ApiException;

    String editPassword(EditPasswordVO editPasswordVO) throws ApiException;

    String forgetPassword(RegisterVO registerVO) throws ApiException;


    int deleteUserById(Integer id) throws ApiException;

    int lockByUid(Integer id) throws ApiException;

    int unlockByUid(Integer id) throws ApiException;


    UserVO getUserInfoByToken();


}
