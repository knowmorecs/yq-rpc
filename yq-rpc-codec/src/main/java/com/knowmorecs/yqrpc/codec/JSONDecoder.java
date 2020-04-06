package com.knowmorecs.yqrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化实现
 * @author knowmoreCS
 * @create 2020-04-03 23:00
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
