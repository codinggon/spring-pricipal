package com.advanced.app.v3;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.hellotrace.HelloTraceV2;
import com.advanced.trace.logtrace.FieldLogTrace;
import com.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV1.request");
            orderService.orderItem(itemId, status);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status,e);
            throw e;//예외를 던져주기
        }

        //예외 터져도 end 호출하려면?

        return "ok";
    }



}
