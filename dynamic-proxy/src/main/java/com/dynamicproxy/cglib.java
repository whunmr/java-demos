package com.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//TASK2

class MyInterceptor implements MethodInterceptor {
    private Object realObj;
    public MyInterceptor(Object obj) {
        this.realObj = obj;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //TODO: 1. print out "dynamic proxy" before call real method
        //TODO: 2. call the real method
        return result;
    }
}

public class cglib {
    public static void main(String[] args) throws InterruptedException {
        createProxy(new Algorithm()).runAlgorithm();
    }

    public static <T> T createProxy(T obj) {
        Enhancer e = new Enhancer();

        e.setSuperclass(
                //TODO: 3. fill here. you can refer to here:http://markbramnik.blogspot.jp/2010/04/cglib-introduction.html
        );

        e.setCallback(
                //TODO: 4. fill here
        );

        return (T) e.create();
    }
}
