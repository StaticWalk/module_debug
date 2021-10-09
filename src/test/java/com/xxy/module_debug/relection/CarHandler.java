package com.xxy.module_debug.relection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarHandler implements InvocationHandler {
    
    private Object car;

    CarHandler(Object object){
        this.car = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object res = method.invoke(car,args);
        System.out.println("after");
        return res;
    }
}
