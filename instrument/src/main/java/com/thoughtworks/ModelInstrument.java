package com.thoughtworks;

import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class ModelInstrument implements ClassFileTransformer {
    public static void premain(String agentArgument, Instrumentation instrumentation) {
        instrumentation.addTransformer(new ModelInstrument());
    }

    public byte[] transform(ClassLoader loader, String className, Class clazz, java.security.ProtectionDomain domain, byte[] bytes) {
        if (className.equals( //TODO: 1 only transform the Algorithm's method )) {
            return transformClass(bytes);
        }

        return bytes;
    }

    private byte[] transformClass(byte[] bytes) {
        ClassPool pool = ClassPool.getDefault();

        try {
            CtClass cl = pool.makeClass(new java.io.ByteArrayInputStream(bytes));
            CtBehavior[] methods = cl.getDeclaredBehaviors();

            for (CtBehavior method : methods) {
                //TODO: 2. CtBehavior has a method called insertBefore
            }

            return cl.toBytecode();
        } catch (Exception e) {}

        return bytes;
    }
}








