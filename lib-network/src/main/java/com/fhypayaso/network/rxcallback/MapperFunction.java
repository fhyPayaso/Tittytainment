package com.fhypayaso.network.rxcallback;

import android.text.TextUtils;

import com.fhypayaso.network.HttpClient;
import com.fhypayaso.network.bean.ApiResponse;
import com.fhypayaso.network.config.NetworkConstants;
import com.fhypayaso.network.exception.ApiException;
import com.fhypayaso.network.exception.ApiExceptionHandler;
import com.fhypayaso.utils.SPUtil;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.Headers;
import retrofit2.Response;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/27/21 10:03 PM
#   @Description   : 
# ====================================================*/
public class MapperFunction<T> implements Function<Response<ApiResponse<T>>, T> {


    @Override
    public T apply(@NonNull Response<ApiResponse<T>> response) throws Exception {

        // 首先检查http请求是否正确
        if (!response.isSuccessful()) {
            throw new ApiException(response.code(), response.message());
        }

        // 从header中获取想要的内容
        parseHeaders(response.headers());

        // 然后检查业务接口是否正确
        ApiResponse<T> apiResponse = response.body();
        if (apiResponse == null) {
            throw new ApiException(ApiExceptionHandler.BODY_EMPTY_ERROR, "返回体为空");
        }

        if (apiResponse.getCode() != NetworkConstants.SUCCESS_CODE) {
            throw new ApiException(apiResponse.getCode(), apiResponse.getMessage());
        }

        if(apiResponse.getData() == null) {
            throw new ApiException(ApiExceptionHandler.BODY_EMPTY_ERROR, "返回体为空");
        }

        return apiResponse.getData();
    }


    void parseHeaders(Headers headers) {

        // 从header中读取token
        String token = headers.get(NetworkConstants.TOKEN_HEADER_KEY);
        if (!TextUtils.isEmpty(token)) {
            SPUtil.putString(HttpClient.instance().getContext(), NetworkConstants.TOKEN_HEADER_KEY, token);
        }
    }

}
