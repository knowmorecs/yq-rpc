package com.knowmorecs.yqrpc.codec;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author knowmoreCS
 * @create 2020-04-05 15:04
 */
public class JSONDecoderTest {
    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("knowmorecs");
        bean.setAge(1);

        byte[] bytes = encoder.encode(bean);
        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes, TestBean.class);

        Assert.assertEquals(bean.getName(), bean2.getName());
        Assert.assertEquals(bean.getAge(), bean2.getAge());
    }
}
