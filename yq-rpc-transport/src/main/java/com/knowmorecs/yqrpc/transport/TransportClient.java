package com.knowmorecs.yqrpc.transport;

import com.knowmorecs.yqrpc.Peer;

import java.io.InputStream;

/**
 * 1. 创建连接
 * 2. 发送数据，并且等待响应
 * 3. 关闭连接
 * @author knowmoreCS
 * @create 2020-04-05 15:09
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream inputStream);

    void close();
}
