package com.advanced.app.v1;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId){
        //저장 로직
        //ex인자값이 들어오면 -> 예외 발생

        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV1.request");
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
