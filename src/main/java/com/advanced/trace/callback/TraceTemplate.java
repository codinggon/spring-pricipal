package com.advanced.trace.callback;

import com.advanced.trace.TraceStatus;
import com.advanced.trace.logtrace.LogTrace;

public class TraceTemplate<T> {

    private final LogTrace logTrace;

    public TraceTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    //어디는 반환하고 안해서 T로
    //타입에 대한 시점을 객체 생성 할때로 미룰때 사용
    public T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);

            //로직 호출
            T result = callback.call();
            logTrace.end(status);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


}
