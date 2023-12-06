package com.advanced.app.test.abstracttest;

public abstract class AbstractTemplate {

    public void execute(){
        long startTime = System.currentTimeMillis();

        call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("resultTime = " + resultTime);


    }


    protected abstract void call();

}
