package com.nhnacademy.batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * demo job 설정 configuration 입니다.
 *
 * @author : 김세미
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class DemoJobConfig {
    // todo 3: job 생성하기
    private final JobBuilderFactory jobBuilderFactory;
    private final Step demoFirstStep;
    private final Step demoSecondStep;

    /**
     * 2개의 step 으로 구성된 Job.
     *
     * @return the job
     */
    @Bean
    public Job demoMultiStepJob(){
        return jobBuilderFactory.get(UUID.randomUUID().toString()) // get() 안에 들어가는 값이 이 Job 의 name 이 된다.
                .start(demoFirstStep) // job 실행시 첫번째 동작 step
                .next(demoSecondStep) // firstStep 이 끝난다음 실행되는 step
                .build();
    }

    /**
     * 1개의 step 으로 구성된 Job.
     *
     * @return the job
     */
//    @Bean
//    public Job demoSingleStepJob(){
//        return jobBuilderFactory.get("demoSingleStepJobName12")
//                .flow(demoFirstStep) // 단일 step
//                .end()
//                .build();
//    }
}
