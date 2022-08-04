package com.nhnacademy.batch.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * firstStep 에서 사용되는 데이터를 write 하기 위한 ItemWriter 구현체입니다.
 *
 * @author : 김세미
 * @since 1.0
 */
@Component
@Slf4j
public class DemoFirstWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) {
        list.forEach(item -> log.info("reader 에서 넘어온 값 : {}", item));
    }
}
