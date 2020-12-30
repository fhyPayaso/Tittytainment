package com.fhypayaso.tittytainment.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/30 10:56 上午
#   @Description   : 
# ====================================================*/
public class AccountLockedException extends AuthenticationException {
    public AccountLockedException(String msg) {
        super(msg);
    }

    public AccountLockedException(String msg, Throwable t) {
        super(msg, t);
    }
}
