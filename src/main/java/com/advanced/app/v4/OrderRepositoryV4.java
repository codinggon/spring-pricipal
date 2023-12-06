package com.advanced.app.v4;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.logtrace.LogTrace;
import com.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId){
        //저장 로직
        //ex인자값이 들어오면 -> 예외 발생

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalArgumentException("예외 발생");
                }
                sleep(1000);
                return null;
            }
        };

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
