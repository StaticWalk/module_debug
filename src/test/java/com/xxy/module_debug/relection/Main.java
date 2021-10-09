package com.xxy.module_debug.relection;

import java.lang.reflect.Proxy;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {
//        CarImpl carImpl = new CarImpl();
//        Car proxy = (Car) Proxy.newProxyInstance(Main.class.getClassLoader(),carImpl.getClass().getInterfaces(), new CarHandler(carImpl));
        Car proxy = (Car) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Car.class},((proxy1, method, args1) ->
        {
            return method.invoke(new CarImpl(),args1);
        }
        ));
        proxy.run();
//        proxy.stop();
//        List<String> list = new ArrayList<>();
//        String xx = "start";
//        t1(xx,list);
//        t2(xx,list);
//        System.out.println(list.size());

//        System.err.println(LocalDateTime.of(
//                LocalDate.now(), LocalTime.of(0, 0, 0)));

    }

    static void t1(String xx, List<String> list ){
        xx = "t1 success";
        list.add(xx);
    }

    static String t2(String xx, List<String> list ){
        list.add(xx);
        return  xx = "t2 success";
    }
}
