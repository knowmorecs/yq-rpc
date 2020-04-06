package com.knowmorecs.yqrpc.example;


import com.knowmorecs.yqrpc.server.RpcServer;

/**
 * @author knowmoreCS
 * @create 2020-04-05 21:49
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
