package com.zjlearn.mock;

import net.andreinc.mockneat.MockNeat;

/**
 * create by zhangjun1 on 2017/9/20
 * 该工具类借助Mockneat实现相关的任意类型的Mock
 */
public class MockService extends MockNeat {
    public <T> T newInstance(Class<T> classType){
        try{
            return ClassMock.newInstance(classType);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
