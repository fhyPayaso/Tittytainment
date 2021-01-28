package com.fhypayaso.network.converter;

import com.fhypayaso.network.bean.ApiResponse;
import com.fhypayaso.network.config.NetworkConstants;
import com.fhypayaso.network.exception.ApiException;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 1:31 AM
#   @Description   : 
# ====================================================*/
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson mGson;
    private final Type mType;

    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.mGson = gson;
        this.mType = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        //将返回的json数据储存在String类型的response中
        String response = value.string();
        //将外层的数据解析到ApiResponse中
        ApiResponse apiResponse = mGson.fromJson(response, ApiResponse.class);
        if (apiResponse == null) {
            throw new IOException("null response");
        }

        if (NetworkConstants.SUCCESS_CODE == apiResponse.getCode()) {
            return mGson.fromJson(response, mType);
        }

        //通过抛出自定义异常传递错误码及错误信息
        throw mGson.fromJson(response, ApiException.class);
    }
}