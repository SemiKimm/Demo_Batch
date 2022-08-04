package com.nhnacademy.batch.processor;

import com.nhnacademy.batch.entity.BatchReadFirst;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * data 를 변환/처리 하기 위한 ItemProcessor 구현체.
 *
 * @author : 김세미
 * @since 1.0
 */
@Component
public class DemoSecondProcessor implements ItemProcessor<BatchReadFirst, BatchReadFirst> {
    // todo 6: step 의 두번째 단계 읽어온 데이터를 변환/처리하는 processor 구현하기
    @Override
    public BatchReadFirst process(BatchReadFirst batchReadFirst) throws Exception {
        batchReadFirst.setResult(batchReadFirst.getPoint() * batchReadFirst.getWeight());

        return batchReadFirst;
    }
}
