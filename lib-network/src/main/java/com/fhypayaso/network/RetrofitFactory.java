package com.fhypayaso.network;

import com.fhypayaso.network.config.NetworkConstants;
import com.fhypayaso.network.interceptor.TokenRequestInterceptor;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/24/21 9:32 PM
#   @Description   : 
# ====================================================*/
public class RetrofitFactory {

    private RetrofitFactory() {
        mServiceCache = new HashMap<>();
    }

    private Retrofit mRetrofit;

    private OkHttpClient mOkHttpClient;

    private HashMap<String, Object> mServiceCache;


    public <T> T createService(Class<T> service) {

        String key = service.getCanonicalName();
        T retrofitService = (T) mServiceCache.get(key);
        if (retrofitService == null) {
            retrofitService = getRetrofit().create(service);
            mServiceCache.put(key, retrofitService);
        }
        return retrofitService;
    }


    private Retrofit getRetrofit() {

        if (mRetrofit == null) {

            mRetrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(NetworkConstants.BASE_SERVER_URL)
                    //增加对返回值为自定义Response类型的支持,默认是Gson
                    .addConverterFactory(GsonConverterFactory.create())
                    //增加对RxJava的适配
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }


    private OkHttpClient getOkHttpClient() {

        if (mOkHttpClient == null) {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            mOkHttpClient = new OkHttpClient.Builder()
                    // 超时时间
                    .connectTimeout(NetworkConstants.SERVER_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    // 失败重试
                    .retryOnConnectionFailure(true)
                    // 日志打印
                    .addInterceptor(loggingInterceptor)
                    // 添加拦截器, 所有请求都在header中添加token
                    .addNetworkInterceptor(new TokenRequestInterceptor())
                    .build();
        }

        return mOkHttpClient;
    }


    private static class InstanceHolder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();
    }

    public static RetrofitFactory instance() {
        return InstanceHolder.INSTANCE;
    }

}
