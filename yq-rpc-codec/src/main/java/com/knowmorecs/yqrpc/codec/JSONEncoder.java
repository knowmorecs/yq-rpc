package com.knowmorecs.yqrpc.codec;
import com.alibaba.fastjson.JSON;

/**
 * 基于json的序列化实现
 * @author knowmoreCS
 * @create 2020-04-03 22:50
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}