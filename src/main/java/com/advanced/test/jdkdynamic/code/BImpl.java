package com.advanced.test.jdkdynamic.code;

public class BImpl implements AInterface{


    @Override
    public String call() {

        System.out.println("BImpl.call");
        return "B";
    }



}
