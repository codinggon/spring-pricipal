package com.advanced.trace.logtrace;

import com.advanced.trace.TraceId;
import com.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class FieldLogTrace implements LogTrace{

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private TraceId traceIdHolder; //traceId 동기화 -- 동시성 이슈

    private void syncTraceId(){
        //최초 호출
        if (traceIdHolder == null) {
            traceIdHolder = new TraceId();
        }else{
            //직전 값이 있다면
            traceIdHolder = traceIdHolder.createNextId(); //level +1
        }
    }

    private void releaseTraceId() {
        if (traceIdHolder.isFirstLevel()) {
            traceIdHolder = null; //destroy
        }else{
            traceIdHolder = traceIdHolder.createPreviousId();//level -1
        }
    }

    @Override
    public TraceStatus begin(String message) {
        //1) TraceId 생성 (id, level)
        syncTraceId();
        TraceId traceId = traceIdHolder;

        Long startTimeMs = System.currentTimeMillis();
        //2)
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        //가져온 getStartTimeMs() 뺌
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        }

        //release : 놓아주다 , 풀어주다
        releaseTraceId();

    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
//        level 0이면 통과 (예외도 통과됨)
        for (int i = 0; i < level; i++) {
            sb.append( (i == level - 1) ? "|" + prefix : "| ");
        }
        return sb.toString();
    }
}
