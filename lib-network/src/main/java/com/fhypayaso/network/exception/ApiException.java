package com.fhypayaso.network.exception;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 12:45 AM
#   @Description   : 
# ====================================================*/
public class ApiException extends IOException {

    /**
     * 错误码
     */
    @SerializedName("code")
    private int code;

    /**
     * 错误信息
     */
    @SerializedName("msg")
    private String msg;

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
