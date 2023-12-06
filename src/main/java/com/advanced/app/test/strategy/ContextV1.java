package com.advanced.app.test.strategy;

public class ContextV1 {

    private final Strategy strategy;


    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("resultTime = " + resultTime);
    }

    public static void main(String[] args) {
        ContextV1 contextV11 = new ContextV1(() -> System.out.println("logic11111aaa"));
        contextV11.execute();
    }


}

