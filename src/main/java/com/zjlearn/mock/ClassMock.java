package com.zjlearn.mock;

import net.andreinc.mockneat.MockNeat;

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
    public static Object newInstance(Class<?> c) throws Exception {
        Object instance = c.newInstance();
        Method[] methods = c.getMethods();
        List<Method> methodList = Arrays.asList(methods);
        Class<?>[] paraTypes = new Class[]{};

        for (Method method : methodList) {
            String name = method.getName();
            if (name.contains("set")) {
                paraTypes = method.getParameterTypes();
                Class paraType = paraTypes[0];
                if (paraType == Integer.class)   //判断参数的类型，并根据类型做相应的初始化调用
                    method.invoke(instance, mock.ints().range(1, 1000).val());
                else if (paraType == Long.class) {
                    method.invoke(instance, mock.longs().range(1, 1000).val());
                } else if (paraType == Double.class)
                    method.invoke(instance, mock.doubles().range(1, 1000).val());
                else if (paraType == String.class)
                    method.invoke(instance, mock.strings());
                else if (paraType == Date.class)
                    method.invoke(instance, mock.localDates().thisMonth());
                else if (true) { //子类，进行组合
                    Class childClass = paraType;
                    method.invoke(instance, ClassMock.newInstance(childClass));
                }
            }
        }
        return instance;  //返回一个Object对象
    }
}
