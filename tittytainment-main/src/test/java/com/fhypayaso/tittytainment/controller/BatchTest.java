package com.fhypayaso.tittytainment.controller;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 9:31 下午
#   @Description   : 
# ====================================================*/

import com.fhypayaso.tittytainment.batch.service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BatchTest {


    @Resource
    private BatchService batchService;


    @Test
    public void initFilmmakerData() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


        long startTime = System.currentTimeMillis();

        batchService.executeFilmmakerBatchJob();

        long duration = System.currentTimeMillis() - startTime;
        log.debug("total time : " + duration);

    }


    @Test
    public void initMovieData() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        long startTime = System.currentTimeMillis();
        batchService.executeMovieBatchJob();

        long duration = System.currentTimeMillis() - startTime;
        log.debug("total time : " + duration);
    }


}
