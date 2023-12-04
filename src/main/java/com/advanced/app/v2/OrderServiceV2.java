package com.advanced.app.v2;

import com.advanced.trace.TraceId;
import com.advanced.trace.TraceStatus;
import com.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;
    public void orderItem(String itemId, TraceStatus status) {
        //sleep : 1초

        try {
            TraceStatus traceStatus = trace.beginSync(status.getTraceId(), "OrderServiceV2.request");
            orderRepository.save(itemId, traceStatus);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status,e);
            throw e;//예외를 던져주기
        }

    }





}
