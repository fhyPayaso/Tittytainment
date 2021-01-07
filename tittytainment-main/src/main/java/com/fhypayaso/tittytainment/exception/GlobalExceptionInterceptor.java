package com.fhypayaso.tittytainment.exception;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 2:54 下午
#   @Description   : 全局异常统一处理
# ====================================================*/


import com.fhypayaso.tittytainment.api.CommonResult;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionInterceptor {


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @Order()
    public CommonResult<String> commonExceptionHandler(Exception exception) {
        log.error(exception.toString());
        return CommonResult.failed(exception.getMessage());

    }

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<String> apiExceptionHandler(ApiException exception) {
        log.error(exception.toString());
        return CommonResult.failed(exception.getMessage());

    }


    /**
     * RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     *
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<String> bodyArgumentValidExceptionHandler(MethodArgumentNotValidException exception) {

        List<FieldError> bindingResult = exception.getBindingResult().getFieldErrors();
        log.debug(String.format("Start : %s : bodyArgumentValidExceptionHandler()", this
                .getClass().getSimpleName()));

        List<String> errorInfoList = new ArrayList<>();
        for (FieldError error : bindingResult) {
            String builder = error.getField() + " : " + error.getDefaultMessage();
            errorInfoList.add(builder);
        }

        return CommonResult.validateFailed(errorInfoList.toString());
    }

    /**
     * RequestParam 上validate失败后抛出的异常是ConstraintViolationException异常。
     *
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<String> argumentValidExceptionHandler(ConstraintViolationException exception) {

        log.debug(String.format("Start : %s : argumentValidExceptionHandler()", this
                .getClass().getSimpleName()));
        return CommonResult.validateFailed(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = TencentCloudSDKException.class)
    public CommonResult<String> smsExceptionHandler(TencentCloudSDKException e) {
        log.error(e.toString());
        return CommonResult.failed("验证码发送失败: " + e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AccountLockedException.class)
    public CommonResult accountLockedExceptionHandler(AccountLockedException e) {
        log.error(e.toString());
        return CommonResult.locked();
    }

}
