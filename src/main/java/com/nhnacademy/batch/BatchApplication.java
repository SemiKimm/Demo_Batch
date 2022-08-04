package com.nhnacademy.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// todo 2: EnableBatchProcessing 어노테이션 활성화 (batch processing 이 가능하도록 설정)
@EnableBatchProcessing
// todo 8: EnableScheduling 어노테이션 활성화 (스케줄링이 가능하도록 설정)
@EnableScheduling
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
