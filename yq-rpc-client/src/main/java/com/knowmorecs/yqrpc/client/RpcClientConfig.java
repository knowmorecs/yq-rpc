package com.knowmorecs.yqrpc.client;

import com.knowmorecs.yqrpc.Peer;
import com.knowmorecs.yqrpc.codec.Decoder;
import com.knowmorecs.yqrpc.codec.Encoder;
import com.knowmorecs.yqrpc.codec.JSONDecoder;
import com.knowmorecs.yqrpc.codec.JSONEncoder;
import com.knowmorecs.yqrpc.transport.HTTPTransportClient;
import com.knowmorecs.yqrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author knowmoreCS
 * @create 2020-04-05 20:51
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass =
            HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass =
            RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}
