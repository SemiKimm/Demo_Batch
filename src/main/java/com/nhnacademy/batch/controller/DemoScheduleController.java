package com.nhnacademy.batch.controller;

import com.nhnacademy.batch.config.DemoJobConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DemoScheduleController {
    private final JobLauncher jobLauncher;
    private final DemoJobConfig jobConfig;

    // todo 9: Scheduled 어노테이션을 통한 작업 반복 실행
//    @Scheduled(fixedDelay = 2000)
    @Scheduled(cron = "0 57 15 * * ?")
    public void doGradeAdvancement() {
        Job job = jobConfig.demoMultiStepJob();
        JobParameters jobParameters = new JobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException
                 | JobParametersInvalidException | JobRestartException e) {
            throw new RuntimeException();
        }
    }
}
