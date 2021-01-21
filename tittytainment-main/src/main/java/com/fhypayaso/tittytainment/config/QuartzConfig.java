package com.fhypayaso.tittytainment.config;

import com.fhypayaso.tittytainment.modules.social.service.LikeService;
import com.fhypayaso.tittytainment.modules.social.task.LikeTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/17 2:28 上午
#   @Description   : 定时任务配置类
# ====================================================*/
@Configuration
public class QuartzConfig {

    private static final String LIKE_TASK_IDENTITY = "LikeTaskQuartz";


    @Bean
    public JobDetail quartzDetail() {
        return JobBuilder.newJob(LikeTask.class).withIdentity(LIKE_TASK_IDENTITY).storeDurably().build();
    }

    @Bean
    public Trigger quartzTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(110)
//                .withIntervalInHours(1)  //一个小时执行一次
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(quartzDetail())
                .withIdentity(LIKE_TASK_IDENTITY)
                .withSchedule(scheduleBuilder)
                .build();
    }

}
