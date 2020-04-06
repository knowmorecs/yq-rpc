package com.knowmorecs.yqrpc.server;


import com.knowmorecs.yqrpc.Request;
import com.knowmorecs.yqrpc.ServiceDescriptor;
import com.knowmorecs.yqrpc.common.utils.ReflectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author knowmoreCS
 * @create 2020-04-05 18:14
 */
public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init(){
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis = sm.lookup(request);

        Assert.assertNotNull(sis);
    }
}