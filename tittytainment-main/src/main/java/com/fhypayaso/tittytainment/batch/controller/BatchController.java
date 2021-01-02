package com.fhypayaso.tittytainment.batch.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.batch.service.BatchService;
import com.fhypayaso.tittytainment.exception.ApiException;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/1 5:29 下午
#   @Description   : 执行批处理文件接口
# ====================================================*/
@RestController
@RequestMapping("/admin/batch")
public class BatchController {


    @Resource
    private BatchService batchService;



    @GetMapping("/movie")
    CommonResult movieBatchJob() throws ApiException, JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ApiException.when(!batchService.executeMovieBatchJob(), "批处理执行失败");
        return CommonResult.success();
    }


    @GetMapping("/filmmaker")
    CommonResult filmmakerBatchJob() throws ApiException, JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ApiException.when(!batchService.executeFilmmakerBatchJob(), "批处理执行失败");
        return CommonResult.success();
    }




}
