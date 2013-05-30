package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//TASK1

interface IServer {
    public void send(String msg);
}

class ServerImpl implements IServer {
    @Override
    public void send(String msg) {
        System.out.println("ServerImpl send: " + msg);
    }
}

class ServerInvocationHandler implements InvocationHandler {
    private final ServerImpl server;
    public ServerInvocationHandler(ServerImpl server) {
        this.server = server;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //TODO: 1. print out "dynamic proxy" before call real method
        //TODO: 2. call the real method

        return result;
    }
}

public class proxy {
    public static void main(String args[]) {
        ServerImpl serverImpl = new ServerImpl();

        IServer server = (IServer) Proxy.newProxyInstance(
                proxy.class.getClassLoader(),

                new Class[]{
                    // TODO: 3. fill interface class you want to proxy
                },

                new ServerInvocationHandler(serverImpl));

        server.send("hello");
    }
}
