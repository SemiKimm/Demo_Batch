package com.nhnacademy.batch.config;

import com.nhnacademy.batch.entity.BatchReadFirst;
import com.nhnacademy.batch.processor.DemoSecondProcessor;
import com.nhnacademy.batch.reader.DemoFirstReader;
import com.nhnacademy.batch.writer.DemoFirstWriter;
import com.nhnacademy.batch.writer.DemoSecondWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManagerFactory;

/**
 * demo step 설정 configuration 입니다.
 *
 * @author : 김세미
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class DemoStepConfig {
    // todo 4: step 생성하기
    private final StepBuilderFactory stepBuilderFactory;
    private final DemoFirstReader demoFirstReader;
    private final DemoFirstWriter demoFirstWriter;
    private final DemoSecondProcessor demoSecondProcessor;
    private final DemoSecondWriter demoSecondWriter;
    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public Step demoFirstStep(){
        return stepBuilderFactory.get("demoFirstStepName")
                .<String, String>chunk(2)
                .reader(demoFirstReader)
                .writer(demoFirstWriter)
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step demoSecondStep(){
        return stepBuilderFactory.get("demoSecondStepName")
                .<BatchReadFirst, BatchReadFirst>chunk(3)
                .reader(progressGradeAdvancementReader())
                .processor(demoSecondProcessor)
                .writer(demoSecondWriter)
                .allowStartIfComplete(true)
                .build();
    }

    /**
     * db 에 저장되어 있는 데이터를 읽기 위한 reader.
     *
     * @return Integer type 의 데이터를 읽는 JpaPagingItemReader 를 반환한다.
     */
    @Bean
    public JpaPagingItemReader<BatchReadFirst> progressGradeAdvancementReader() {
        return new JpaPagingItemReaderBuilder<BatchReadFirst>()
                .name("progressGradeAdvancementReader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(3)
                .queryString("SELECT b FROM BatchReadFirst b ")
                .build();
    }
}
