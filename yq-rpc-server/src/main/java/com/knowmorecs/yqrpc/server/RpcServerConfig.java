package com.knowmorecs.yqrpc.server;

import com.knowmorecs.yqrpc.codec.Decoder;
import com.knowmorecs.yqrpc.codec.Encoder;
import com.knowmorecs.yqrpc.codec.JSONDecoder;
import com.knowmorecs.yqrpc.codec.JSONEncoder;
import com.knowmorecs.yqrpc.transport.HTTPTransportServer;
import com.knowmorecs.yqrpc.transport.TransportServer;
import lombok.Data;

/**
 * server配置
 *  1. 使用哪个网络模块
 *  2. 使用哪个序列化的实现
 *  3. 启动之后监听什么端口
 * @author knowmoreCS
 * @create 2020-04-05 16:05
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    //RPC Server监听的端口
    private int port = 3000;

}
