package com.knowmorecs.yqrpc;

import lombok.Data;

/**
 * 表示RPC的返回
 * @author knowmoreCS
 * @create 2020-04-03 21:47
 */
@Data
public class Response {
    /**
     * 服务返回编码，0-成功 非 0-失败
     */
    private int code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     * 返回的数据
     */
    private Object data;
}
