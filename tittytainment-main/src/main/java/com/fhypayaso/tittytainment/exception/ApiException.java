package com.fhypayaso.tittytainment.exception;

import com.google.common.base.Supplier;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 3:03 下午
#   @Description   : 
# ====================================================*/
public class ApiException extends Exception{


    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, Object... args) {
        super(String.format(msg, args));
    }

    public static void when(boolean condition, Supplier<String> msgSupplier) throws ApiException {
        if (condition) throw new ApiException(msgSupplier.get());
    }

    public static void when(boolean condition, String msg) throws ApiException {
        if (condition) throw new ApiException(msg);
    }

    public static void with(String msg) throws ApiException {
        throw new ApiException(msg);
    }


}
