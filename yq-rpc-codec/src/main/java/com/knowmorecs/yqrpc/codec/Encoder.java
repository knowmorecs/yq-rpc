package com.knowmorecs.yqrpc.codec;

/**
 * 序列化模块：将对象转为二进制数组
 * @author knowmoreCS
 * @create 2020-04-03 22:46
 */
public interface Encoder {
    byte[] encode(Object obj);
}
