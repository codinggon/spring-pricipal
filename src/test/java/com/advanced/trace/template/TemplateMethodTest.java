package com.advanced.trace.template;

import com.advanced.trace.template.code.AbstractTemplate;
import com.advanced.trace.template.code.SubClassLogic1;
import com.advanced.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {
    /**
     *
     * 탭플릿 메소드 반영
     */
    @DisplayName("")
    @Test
    public void _테스트1() throws Exception{
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate logic2 = new SubClassLogic2();
        logic2.execute();

    }

    /**
     * 익명 내부 클래스
     */
    @DisplayName("")
    @Test
    public void _테스트2() throws Exception{
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                System.out.println("TemplateMethodTest.call");
            }
        };
        template1.execute();




    }

    @DisplayName("")
    @Test
    public void _테스트() throws Exception{
        logic1();
        logic2();
    }


    private void logic1(){
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("resultTime = " + resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        System.out.println("비지니스 로직2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("resultTime = " + resultTime);
    }


}
