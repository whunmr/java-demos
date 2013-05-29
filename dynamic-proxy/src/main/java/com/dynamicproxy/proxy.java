package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IServer {
    public void send(String msg);
    public String receive();
}

class ServerImpl implements IServer {
    @Override
    public void send(String msg) {
        System.out.println("ServerImpl send: \"" + msg + "\"");
    }

    @Override
    public String receive() {
        System.out.println("ServerImpl receive.");
        return "received message";
    }
}

class ServerInvocationHandler implements InvocationHandler {
    private final ServerImpl server;

    public ServerInvocationHandler(ServerImpl server) {
        this.server = server;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("calling start---> :" + method.getName());
        Object result = method.invoke(server, args);
        System.out.println("calling end---> :" + method.getName());

        return result;
    }
}

public class proxy {
    public static void main(String args[]) {
        IServer server = (IServer) Proxy.newProxyInstance(proxy.class.getClassLoader(),
                new Class[]{IServer.class},
                new ServerInvocationHandler(new ServerImpl()));

        server.send("hello");
    }
}
