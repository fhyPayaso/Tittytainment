package com.fhypayaso.tittytainment.batch.filmmaker.step;

import com.fhypayaso.tittytainment.modules.movie.service.FilmmakerService;
import com.fhypayaso.tittytainment.modules.movie.service.ProfessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 4:59 下午
#   @Description   : 
# ====================================================*/
@Slf4j
public class FilmmakerBatchJobListener implements JobExecutionListener {

    @Resource
    private FilmmakerService filmmakerService;

    @Resource
    private ProfessionService professionService;



    @Override
    public void beforeJob(JobExecution jobExecution) {

//        filmmakerService.deleteAll();
//        professionService.deleteAll();
//        professionService.deleteAllFilmmakerProfession();

    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
