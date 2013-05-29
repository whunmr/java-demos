package com.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class Algorithm {
    public void runAlgorithm() throws InterruptedException {
        System.out.println("running the algorithm");
        Thread.sleep(500);
    }
}

class MyInterceptor implements MethodInterceptor {
    private Object realObj;
    public MyInterceptor(Object obj) {
        this.realObj = obj;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before");

        long time1 = System.currentTimeMillis();
        Object res = method.invoke(realObj, objects);

        System.out.println("After");
        System.out.println("Took: " + (System.currentTimeMillis() - time1) + " ms");
        return res;
    }
}

public class cglib {
    public static void main(String[] args) throws InterruptedException {
        createProxy(new Algorithm()).runAlgorithm();
    }

    public static <T> T createProxy(T obj) {
        Enhancer e = new Enhancer();
        e.setSuperclass(obj.getClass());
        e.setCallback(new MyInterceptor(obj));

        return (T) e.create();
    }
}
