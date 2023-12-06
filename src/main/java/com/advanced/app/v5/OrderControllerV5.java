package com.advanced.app.v5;

import com.advanced.app.test.callbacktest.Callback;
import com.advanced.trace.callback.TraceCallback;
import com.advanced.trace.callback.TraceTemplate;
import com.advanced.trace.logtrace.LogTrace;
import com.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace logTrace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(logTrace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return (String) template.execute("OrderControllerV5.request", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });


    }



}
