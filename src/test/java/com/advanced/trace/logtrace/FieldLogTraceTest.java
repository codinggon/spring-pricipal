package com.advanced.trace.logtrace;

import com.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRange;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class FieldLogTraceTest {

    @Autowired
    private FieldLogTrace trace;





    @DisplayName("")
    @Test
    public void _테스트() throws Exception{
        TraceStatus hello1 = trace.begin("ex");
        TraceStatus hello2 = trace.begin("hello2");
        trace.exception(hello2, new IllegalArgumentException());
        trace.exception(hello1, new IllegalArgumentException());

    }


}