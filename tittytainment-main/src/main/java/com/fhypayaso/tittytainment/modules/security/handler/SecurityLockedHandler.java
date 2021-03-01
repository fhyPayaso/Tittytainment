package com.fhypayaso.tittytainment.modules.security.handler;

import com.alibaba.fastjson.JSON;
import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 12:45 上午
#   @Description   : 账户被锁定的处理方法
# ====================================================*/
@Component
public class SecurityLockedHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSON.toJSONString(CommonResult.authorizationError(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}
