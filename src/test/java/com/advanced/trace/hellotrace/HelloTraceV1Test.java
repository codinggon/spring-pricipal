package com.advanced.trace.hellotrace;

import com.advanced.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV1Test {

    @DisplayName("")
    @Test
    public void _테스트() throws Exception{
        HelloTraceV1 trace = new HelloTraceV1();
        //"hello" 메시지
        //TraceStatus(traceId(id, level), startTimeMs, message
        TraceStatus status = trace.begin("hello"); //[609d4f63] hello
        trace.end(status); //[609d4f63] hello time=207599ms


    }

}