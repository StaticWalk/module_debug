package com.xxy.module_debug.parallel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BigTest {


    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
//        List<String> result = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i+"");
        }
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        list.stream().filter(Objects::nonNull).forEach(result::add);

        System.err.println(result.size());



    }
}
