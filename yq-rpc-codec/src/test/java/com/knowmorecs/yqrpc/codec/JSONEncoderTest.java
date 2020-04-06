package com.knowmorecs.yqrpc.codec;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author knowmoreCS
 * @create 2020-04-03 23:02
 */
public class JSONEncoderTest {
    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("knowmorecs");
        bean.setAge(1);

        byte[] bytes = encoder.encode(bean);
        Assert.assertNotNull(bytes);
    }
}
