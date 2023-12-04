package com.advanced.app.v2;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.hellotrace.HelloTraceV1;
import com.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(String itemId, TraceStatus status){
        //저장 로직
        //ex인자값이 들어오면 -> 예외 발생

        try {
            status = trace.beginSync(status.getTraceId(),"OrderRepositoryV2.request");
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외 발생");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status,e);
            throw e;//예외를 던져주기
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
