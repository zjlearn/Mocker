package com.zjlearn.mock;

import net.andreinc.mockneat.MockNeat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * create by zhangjun1 on 2017/9/20
 * 该类负责class类的一个任意的实例化。
 */
public class ClassMock {

    //依赖mock生成相关的随机化的
    private static MockNeat mock = MockNeat.threadLocal();

    //返回的是Class类的实例
    public static <T> T newInstance(Class<T> c) throws Exception {

        T instance = c.newInstance();
        Field[] allFields=c.getDeclaredFields();
        if(allFields!=null){
            for(Field field:allFields){
                Class fieldType=field.getType();
                field.setAccessible(true);
                if (fieldType == Integer.class || fieldType==int.class)   //判断参数的类型，并根据类型做相应的初始化调用
                    field.set(instance,mock.ints().range(1, 1000).val());
                else if (fieldType == Long.class|| fieldType==long.class) {
                    field.set(instance, mock.longs().range(1, 1000).val());
                }else if(fieldType == Float.class|| fieldType==float.class){
                    field.set(instance,mock.floats().range(1, 1000).val());
                } else if (fieldType == Double.class|| fieldType==double.class)
                    field.set(instance,mock.doubles().range(1, 1000).val());
                else if (fieldType == String.class)
                    field.set(instance,mock.strings().toString());
                else if (fieldType == Date.class)
                    field.set(instance,mock.localDates().thisMonth());
                else if (true) { //子类，进行组合
                    Class childClass = fieldType;
                    field.set(instance, ClassMock.newInstance(childClass));
                }
            }
        }
        return instance;  //返回一个Object对象
    }
}
