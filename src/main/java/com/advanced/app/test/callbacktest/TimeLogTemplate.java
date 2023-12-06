package com.advanced.app.test.callbacktest;

public class TimeLogTemplate {


    public void execute(Callback callback){

        long startTime = System.currentTimeMillis();
        callback.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("resultTime = " + resultTime);
    }


    public static void main(String[] args) {

        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> System.out.println("TimeLogTemplate.call"));


    }

}

















