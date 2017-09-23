package com.zjlearn.mock;

import java.util.ArrayList;
import java.util.List;

/**
 * create by zhangjun1 on 2017/9/23
 * 查找指定路径下面实现指定接口的全部类
 *
 */
public class ClassUtil {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List<Class> getAllClassByInterface(Class clazz){
        List<Class> classList = new ArrayList();
        //判断是否是一个接口
        if (clazz.isInterface()) {
            try {
                List<Class> allClass = getAllClass();
                /**
                 * 循环判断路径下的所有类是否实现了指定的接口
                 * 并且排除接口类自己
                 */
                for (int i = 0; i < allClass.size(); i++) {
                    if (clazz.isAssignableFrom(allClass.get(i))) {
                        if (!clazz.equals(allClass.get(i))) //自身并不加进去
                            classList.add(allClass.get(i));
                    }
                }
            } catch (Exception e) {
                System.out.println("出现异常");
            }
        }else {
            //如果不是接口不作处理
        }
        return classList;
    }

    public static List<Class> getAllClass(){
        return null;
    }

}