package com.knowmorecs.yqrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的Handler
 * @author knowmoreCS
 * @create 2020-04-05 15:23
 */
public interface RequestHandler {
    void onRequest(InputStream recive, OutputStream toResp);
}
