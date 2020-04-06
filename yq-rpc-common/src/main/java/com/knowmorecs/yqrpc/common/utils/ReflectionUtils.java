package com.knowmorecs.yqrpc.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 *
 * getPublicMethods()方法一个用途是Server注册时存储所有的method的ServiceDescriptor。
 * invoke()方法用于执行指定实例对象的method。
 *
 * @author knowmoreCS
 * @create 2020-04-03 21:54
 */
public class ReflectionUtils {
    public static <T> T newInstance(Class<T> clazz){
        /**
         * 根据class创建对象
         *
         */
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个class的公有方法
     * @param clazz
     * @return 当前类声明的共有方法
     */
    public static Method[] getPublicMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = new ArrayList<>();
        for (Method m : methods){
            if (Modifier.isPublic(m.getModifiers())){
                pmethods.add(m);
            }
        }
        return pmethods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     *
     * @param obj 被调用方法的对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * @return 返回结果
     */
    public static Object invoke(Object obj,
                                Method method,
                                Object... args){
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
