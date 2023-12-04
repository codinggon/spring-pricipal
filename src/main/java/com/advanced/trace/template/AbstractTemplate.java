package com.advanced.trace.template;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    //어디는 반환하고 안해서 T로
    //타입에 대한 시점을 객체 생성 할때로 미룰때 사용
    public T execute(String message) {
        TraceStatus status = null;
        return null;
    }

}
