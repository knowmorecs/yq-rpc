package com.knowmorecs.yqrpc;

import lombok.Data;

/**
 * 表示 RPC 的一个请求
 *
 * 用于储存某一需要执行方法的 method 描述（即 serviceDescriptor）与实参
 * 这里的实参将会在client调用方法时通过动态代理获取，并且通过http协议传递到Server进行处理。
 * 而在Server中会根据传递的class与实例通过反射进行实际方法的执行，
 * 最后将执行结果通过Response类进行返回。
 *
 * @author knowmoreCS
 * @create 2020-04-03 21:43
 */

@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameter;
}
