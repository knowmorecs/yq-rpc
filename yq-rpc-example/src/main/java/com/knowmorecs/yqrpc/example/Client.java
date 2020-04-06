package com.knowmorecs.yqrpc.example;

import com.knowmorecs.yqrpc.client.RpcClient;

/**
 * @author knowmoreCS
 * @create 2020-04-05 21:49
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1, 2);
        int r2 = service.delete(1, 2);
        System.out.println(r1);
        System.out.println(r2);
    }
}