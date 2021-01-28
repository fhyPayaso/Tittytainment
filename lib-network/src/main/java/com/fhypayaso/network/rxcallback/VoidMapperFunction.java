package com.fhypayaso.network.rxcallback;

import com.fhypayaso.network.bean.ApiResponse;

import io.reactivex.annotations.NonNull;
import retrofit2.Response;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/28/21 12:03 AM
#   @Description   : 
# ====================================================*/
public class VoidMapperFunction extends MapperFunction<Integer> {

    @Override
    public Integer apply(@NonNull Response<ApiResponse<Integer>> response) throws Exception {
        super.apply(response);
        return 0;
    }
}
