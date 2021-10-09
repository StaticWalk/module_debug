package com.xxy.module_debug.relection;

public class CarImpl implements Car {
    @Override
    public void run() {
        System.out.println("car run");
    }

    @Override
    public void stop() {
        System.out.println("car stop");
    }
}
