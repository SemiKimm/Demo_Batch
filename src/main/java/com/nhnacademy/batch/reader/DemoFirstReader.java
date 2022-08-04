package com.nhnacademy.batch.reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * firstStep 에서 사용되는 데이터를 읽기위한 ItemReader 구현체입니다.
 *
 * @author : 김세미
 * @since 1.0
 */
@Component
@Slf4j
public class DemoFirstReader implements ItemReader<String> {
    // todo 5: step 의 첫번째 단계 reader 구현하기
    private Integer count = 0; // todo 8: 무한루프를 종료하기 위한 count 설정

    @Override
    public String read() {
        log.info("demoFirstReader 실행");
        this.count ++;
        if(count > 1){
            return null;
        }
        return "demoFirstReader progress";
    }
}
