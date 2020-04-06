package com.knowmorecs.yqrpc.common.utils;


import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author knowmoreCS
 * @create 2020-04-03 22:19
 */
public class ReflectionUtilsTest {


    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        Assert.assertNotNull(t);
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Assert.assertEquals(1, methods.length);
        String name = methods[0].getName();
        Assert.assertEquals("b", name);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];
        TestClass t = new TestClass();
        Object r = ReflectionUtils.invoke(t, b);
        Assert.assertEquals("b", r);
    }
}
