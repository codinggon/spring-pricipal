package com.advanced.app.v5;

import com.advanced.trace.callback.TraceCallback;
import com.advanced.trace.callback.TraceTemplate;
import com.advanced.trace.logtrace.LogTrace;
import com.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final LogTrace trace;
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace, LogTrace logTrace) {
        this.trace = trace;
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId){
        //저장 로직
        //ex인자값이 들어오면 -> 예외 발생

        template.execute("message", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외 발생");
            }
            sleep(1000);
            return null;
        });


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
