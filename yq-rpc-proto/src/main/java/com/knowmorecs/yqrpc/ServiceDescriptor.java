package com.knowmorecs.yqrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * 表示服务
 *
 * 该类主要用于存储方法信息，
 * 而在Server中会将类映射到对应于该类的具体实例，
 * 以便反射执行具体方法。
 * @author knowmoreCS
 * @create 2020-04-03 20:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    private String clazz;   //类名
    private String method;  //方法名
    private String returnType;  //返回类型
    private String[] parameterTypes;    //参数类型

    public static ServiceDescriptor from(Class clazz, Method method){
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class[] parameterClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];
        //拿到所有参数类型的string数组
        for (int i = 0; i < parameterClasses.length; i++) {
            parameterTypes[i] = parameterClasses[i].getName();
        }
        sdp.setParameterTypes(parameterTypes);

        return sdp;
    }

    @Override
    public String toString() {
        return "clazz=" + clazz
                + ",method=" + method
                + ",returnType=" + returnType
                + ",parameterTypes=" + Arrays.toString(parameterTypes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDescriptor that = (ServiceDescriptor)o;
        return this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
