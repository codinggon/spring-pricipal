package com.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {


    //쓰레드란 프로그램 실행의 가장 작은 단위
    //일반적으로 자바 애플리케이션을 만들어 실행하면 1개의 메인(main) 쓰레드에 의해 프로그램이 실행
    //하지만 1개의 쓰레드 만으로는 동시에 여러 작업을 할 수 없다.
    //동시에 여러 작업을 처리하고 싶다면, 별도의 쓰레드를 만들어 실행

    //방법1)  MyThread extends Thread
//    Thread thread = new MyThread();
//    thread.start();

    //지역변수에서는 발생하지 않는다. -> 지역마다 쓰레드가 다른 메모리에 할당됨
    //발생하는 경우 (인스턴스의 필드, 또는 static 같은 공용필드에서 발생)
    //값을 읽기만 할 때는 발생하지않는다.
    //

    //ThreadLocal -> 자바
    //userA 저장 -> userA 전용 Thread 저장소 저장
    //userB 저장 -> userB 전용 Thread 저장소 저장

    private FieldService fieldService = new FieldService();
    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @DisplayName("")
    @Test
    public void _테스트() throws Exception{
        System.out.println("main.start");

        //방법2)
        Runnable userA = () -> {
//            fieldService.logic("userA");
            threadLocalService.logic("userA");
        };
        Runnable userB = () -> {
//            fieldService.logic("userB");
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100); //동시성 문제 -> A의 처리가 끝나기 전에 B가 접근하게 된다.
        threadB.start();
        sleep(2000); //메인 쓰레드 종료 대기

        System.out.println("main.end");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
