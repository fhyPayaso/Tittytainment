package com.fhypayaso.network.interceptor;

import com.fhypayaso.network.HttpClient;
import com.fhypayaso.network.config.NetworkConstants;
import com.fhypayaso.utils.SPUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/24/21 9:54 PM
#   @Description   : 
# ====================================================*/
public class TokenRequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = SPUtil.getString(HttpClient.instance().getContext(), NetworkConstants.TOKEN_HEADER_KEY);
        return chain.proceed(
                chain.request()
                        .newBuilder()
                        .addHeader(NetworkConstants.TOKEN_HEADER_KEY, token)
                        .build()
        );
    }
}
