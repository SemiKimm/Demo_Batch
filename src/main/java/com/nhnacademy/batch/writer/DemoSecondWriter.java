package com.nhnacademy.batch.writer;

import com.nhnacademy.batch.entity.BatchReadFirst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 데이터 처리를 위한 ItemWriter 구현체.
 *
 * @author : 김세미
 * @since 1.0
 */
@Component
@Slf4j
public class DemoSecondWriter implements ItemWriter<BatchReadFirst> {
    // todo 7: step 의 마지막 단계 변환/처리한 데이터를 write 하는 writer 구현하기
    @Override
    public void write(List<? extends BatchReadFirst> list) throws Exception {
        list.forEach(item ->
            log.info("write 동작 : {}", item.getResult())
        );
    }
}
