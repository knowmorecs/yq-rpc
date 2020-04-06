package com.knowmorecs.yqrpc.example;

/**
 * @author knowmoreCS
 * @create 2020-04-05 21:51
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int delete(int a, int b) {
        return a-b;
    }
}
