//package com.advanced.app.v0;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@RequiredArgsConstructor
//public class OrderRepositoryV0 {
//
//    public void save(String itemId){
//        //저장 로직
//        //ex인자값이 들어오면 -> 예외 발생
//        if (itemId.equals("ex")) {
//            throw new IllegalArgumentException("예외 발생");
//        }
//        sleep(1000);
//
//    }
//
//    private void sleep(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
