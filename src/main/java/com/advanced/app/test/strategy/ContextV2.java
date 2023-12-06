package com.advanced.app.test.strategy;

public class ContextV2 {

    public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("resultTime = " + resultTime);
    }

    public static void main(String[] args) {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> System.out.println("ContextV2.call"));



    }


}

