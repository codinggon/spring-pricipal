package com.advanced.test.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
public class AImpl implements AInterface{


    @Override
    public String call() {
        System.out.println("AImpl.call");
        return "A";
    }

    public static void main(String[] args) {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        //동적으로 프록시 생성 / 어떤 인터페이스 기반으로 만들고, 어떤 로직이야?
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.call();
        log.info("targetclass={}",target.getClass()    );
        log.info("proxyclass={}",proxy.getClass()    );



    }



}
