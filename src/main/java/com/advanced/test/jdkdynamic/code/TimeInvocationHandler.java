package com.advanced.test.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("timeproxy 실행");
        long startTime = System.currentTimeMillis();

        Object invoke = method.invoke(target, args);

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        System.out.println("timeproxy 종료 >> resultTime = " + resultTime);

        return invoke;
    }
}
