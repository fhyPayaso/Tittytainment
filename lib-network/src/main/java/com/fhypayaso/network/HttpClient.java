package com.fhypayaso.network;

import android.app.Application;

/* ====================================================
#   Copyright (C)2019 2021 fhyPayaso All rights reserved.
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/24/21 9:23 PM
#   @Description   : 
# ====================================================*/
public class HttpClient {


    private Application mApplication;

    private HttpClient() {
    }

    private static class InstanceHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }


    public static HttpClient instance() {
        return InstanceHolder.INSTANCE;
    }

    public Application getContext() {

        return mApplication;
    }

    public void init(Application app) {
        mApplication = app;
    }

    public <T> T createService(Class<T> service) {
        return RetrofitFactory.instance().createService(service);
    }


}
