package com.fhypayaso.tittytainment.modules.security.handler;

import com.alibaba.fastjson.JSON;
import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.AccountLockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 8:07 下午
#   @Description   : 没有携带token或token无效的处理方法
# ====================================================*/
@Component
public class SecurityInvalidTokenHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSON.toJSONString(CommonResult.unauthorized()));
        httpServletResponse.getWriter().flush();
    }
}
