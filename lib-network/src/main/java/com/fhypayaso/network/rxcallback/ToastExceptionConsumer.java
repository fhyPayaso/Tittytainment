package com.fhypayaso.network.rxcallback;

import android.text.TextUtils;

import com.fhypayaso.network.HttpClient;
import com.fhypayaso.network.exception.ApiException;
import com.fhypayaso.network.exception.ApiExceptionHandler;
import com.fhypayaso.utils.ToastUtil;

import io.reactivex.functions.Consumer;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 1:15 AM
#   @Description   : 
# ====================================================*/
public class ToastExceptionConsumer implements Consumer<Throwable> {
    @Override
    public void accept(Throwable throwable) throws Exception {
        ApiException exception = ApiExceptionHandler.handleException(throwable);
        ToastUtil.showToast(HttpClient.instance().getContext(), exception.getMsg());
    }
}
