package com.knowmorecs.yqrpc.codec;

/**
 * 反序列化
 * @author knowmoreCS
 * @create 2020-04-03 22:48
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
