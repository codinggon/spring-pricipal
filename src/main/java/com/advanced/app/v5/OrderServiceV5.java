package com.advanced.app.v5;

import com.advanced.trace.callback.TraceCallback;
import com.advanced.trace.callback.TraceTemplate;
import com.advanced.trace.logtrace.LogTrace;
import com.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate traceTemplate;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        //sleep : 1초

        traceTemplate.execute("OrderServiceV4.request", new TraceCallback() {
            @Override
            public Object call() {
                orderRepository.save(itemId);
                return null;
            }
        });


    }





}
