package com.advanced.app.v2;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
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
