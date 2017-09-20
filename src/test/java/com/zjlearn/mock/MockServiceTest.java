package com.zjlearn.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * create by zhangjun1 on 2017/9/20
 */
@RunWith(JUnit4.class)
public class MockServiceTest {

    private MockService mockService = new MockService();

    @Test
    public void testFloat() {
        float k = mockService.floats().range(1, 6).val();
        System.out.println(k);
    }

    @Test
    public void testDouble() {
        System.out.println(mockService.days().val());
//        System.out.println(k);
    }

    @Test
    public void testClass() {
        Student student = (Student) mockService.newInstance(Student.class);
        System.out.println(student);
    }

    @Test
    public void  testNestClass(){

    }
}
