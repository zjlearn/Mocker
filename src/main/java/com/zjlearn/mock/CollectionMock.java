package com.zjlearn.mock;

import net.andreinc.mockneat.MockNeat;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * create by zhangjun1 on 2018/2/28
 * 模拟出一个集合对象，
 */
public class CollectionMock {

    //依赖mock生成相关的随机化的
    private static MockNeat mock = MockNeat.threadLocal();

    //返回的是Class类的实例
    public static <T> T newCollectionInstance(Collection<T> set, int len, Class<T> c) throws Exception {
        T instance = c.newInstance();
        Field[] allFields = c.getDeclaredFields();

        return instance;  //返回一个Object对象
    }
}
