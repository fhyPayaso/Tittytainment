package com.fhypayaso.tittytainment.exception;

import org.springframework.security.core.AuthenticationException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/30 11:34 上午
#   @Description   : 
# ====================================================*/
public class TokenErrorException extends AuthenticationException {

    public TokenErrorException(Throwable cause) {
        super("token异常:" + cause.getMessage(), cause);
    }

    public TokenErrorException() {
        super("token异常");
    }
}
