package com.fhypayaso.tittytainment.modules.security.filter;

import com.alibaba.fastjson.JSON;
import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.AccountLockedException;
import com.fhypayaso.tittytainment.modules.security.dto.JwtUser;
import com.fhypayaso.tittytainment.modules.security.service.SecurityDetailsService;
import com.fhypayaso.tittytainment.modules.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 8:33 下午
#   @Description   : 
# ====================================================*/
public class JwtTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private SecurityDetailsService securityDetailsService;


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 先从请求中拿到token
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        String token = httpRequest.getHeader(tokenHeader);
        // 从token中解析出手机号
        String phoneNumber = jwtTokenUtil.parsePhoneNumber(token);
        if (!StringUtils.isEmpty(phoneNumber) && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = securityDetailsService.loadUserByUsername(phoneNumber);

            if (jwtTokenUtil.validateToken(token, userDetails)) {
                // 生成通过认证
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                // 将权限写入本次会话
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            if (!userDetails.isEnabled()) {
                unsuccessfulAuthentication(httpRequest, httpResponse, new AccountLockedException(null));
                return;
            }
        }
        chain.doFilter(req, res);
    }
}
