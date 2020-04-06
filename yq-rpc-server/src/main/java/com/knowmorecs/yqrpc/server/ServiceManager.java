package com.knowmorecs.yqrpc.server;

import com.knowmorecs.yqrpc.Request;
import com.knowmorecs.yqrpc.ServiceDescriptor;
import com.knowmorecs.yqrpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务
 *  注册服务-和-查找服务
 * @author knowmoreCS
 * @create 2020-04-05 16:46
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean){
        //将interfaceClass接口中的所有方法扫描出来
        //和bean绑定起来
        //形成一个ServiceInstance，放到map中
        //这样我们就把interfaceClass里面的method都当成服务注册到ServiceManager里面了
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods){
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            services.put(sdp, sis);
            log.info("register service: {} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
