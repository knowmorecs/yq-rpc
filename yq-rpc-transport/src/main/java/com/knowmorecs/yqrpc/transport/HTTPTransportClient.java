package com.knowmorecs.yqrpc.transport;

import com.knowmorecs.yqrpc.Peer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Peer类为定义在Proto模块中的Server通信地址与端口不做特殊介绍。
 * 该类主要方法为write(),主要是用于向server传递数据并且获取响应数据。
 * 其最终调用将在RpcClient类中调用。
 *
 * @author knowmoreCS
 * @create 2020-04-05 15:27
 */
public class HTTPTransportClient implements TransportClient {
    private String url;

    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":"
                + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConn = (HttpURLConnection)new URL(url).openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");

            httpConn.connect();
            IOUtils.copy(data, httpConn.getOutputStream());

            int resultCode = httpConn.getResponseCode();
            if (resultCode == HttpURLConnection.HTTP_OK){
                return httpConn.getInputStream();
            } else {
                return httpConn.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
