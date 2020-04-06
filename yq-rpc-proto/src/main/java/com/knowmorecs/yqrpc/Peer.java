package com.knowmorecs.yqrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示网络传输的一个端点
 * @author knowmoreCS
 * @create 2020-04-03 20:54
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;

}
