package com.advanced.app.v3;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.hellotrace.HelloTraceV2;
import com.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;
    public void orderItem(String itemId, TraceStatus status) {
        //sleep : 1초

        try {
            TraceStatus traceStatus = trace.begin("OrderServiceV2.request");
            orderRepository.save(itemId, traceStatus);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status,e);
            throw e;//예외를 던져주기
        }

    }





}
