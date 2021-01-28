package com.fhypayaso.network.bean;

import com.google.gson.annotations.SerializedName;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 12:39 AM
#   @Description   : 
# ====================================================*/
public class ApiResponse<T> {

    @SerializedName("code")
    private int code;

    @SerializedName("msg")
    private String message;

    @SerializedName("data")
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
