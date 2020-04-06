package com.knowmorecs.yqrpc.client;

import com.knowmorecs.yqrpc.codec.Decoder;
import com.knowmorecs.yqrpc.codec.Encoder;
import com.knowmorecs.yqrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @author knowmoreCS
 * @create 2020-04-05 21:00
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );
    }

    // getClass().getClassLoader()  类加载器
    // new Class[]{clazz}   要加载的类的接口的类
    // new RemoteInvoker(clazz, encoder, decoder, selector) 代理逻辑执行器
    public  <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }
}
