package com.knowmorecs.yqrpc.server;

import com.knowmorecs.yqrpc.Request;
import com.knowmorecs.yqrpc.common.utils.ReflectionUtils;

/**
 * 调用具体服务
 * @author knowmoreCS
 * @create 2020-04-05 19:07
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service,
                         Request request){
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameter()
        );
    }
}
