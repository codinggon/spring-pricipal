package com.advanced.test.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    static class Hello{
        public String callA(){
            log.info("Hello.callA");

            return "A";
        }
        public String callB(){
            log.info("Hello.callB");
            return "B";
        }


    }

    public static void main(String[] args) throws Exception {

//        Hello target = new Hello();
//
//        //공통 로직1
//        System.out.println("start");
//        String callA = target.callA();
//        System.out.println("result = " + callA);
//
//        System.out.println("start");
//        String callB = target.callB();
//        System.out.println("result = " + callB);




        //class 메타 정보 획득
//        Class classHello = Class.forName("com.advanced.test.jdkdynamic.ReflectionTest$Hello");
//        Hello target = new Hello();
//
//        //메서드가 추상화 되었다.
//        //callA 메서드 정보
//        Method callA1 = classHello.getMethod("callA");
//        Object result1 = callA1.invoke(target); //callA 호출 (Hello 인스턴스에 있는)
//        log.info("result = {}",result1);
//
//        //callA 메서드 정보
//        Method callB1 = classHello.getMethod("callB");
//        Object result2 = callB1.invoke(target); //callA 호출 (Hello 인스턴스에 있는)
//        log.info("result = {}",result2);


        //class 메타 정보 획득
        Class classHello = Class.forName("com.advanced.test.jdkdynamic.ReflectionTest$Hello");
        Hello target = new Hello();

        //메서드가 추상화 되었다.
        //callA 메서드 정보
        //리플랙션을 사용해서 메타정보로 바꿔치기
        Method callA1 = classHello.getMethod("callA");
        dynamicCall(callA1, target);

        //callA 메서드 정보
        Method callB1 = classHello.getMethod("callB");
        dynamicCall(callB1, target);


    }

    /**
     * 메서드 추상화 (리플랙션) -> reflection (반사)
     * 런타임 오류 -> 오류를 잡을 수가 없다. / 그래서 사용 자제...
     * @param method 호출할 메서드
     * @param target 해당 객체
     */
    private static void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        System.out.println("start");
        Object result = method.invoke(target);
        System.out.println("result = " + result);

    }

}
