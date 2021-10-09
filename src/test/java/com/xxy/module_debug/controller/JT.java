package com.xxy.module_debug.controller;

import com.xxy.module_debug.utils.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.util.CollectionUtils;

import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JT {

    private static Map<String,String> big = new HashMap<>();

    public static void main(String[] args) {

//        String type = "data";
//        // id1 aaa; id2 999
//
//        putMap("data","id1","aaa");
//        putMap("data","id2","666");
//        putMap("data","id3",88);
//
//
//        Map<String,Object> result = getFromMap("data");

        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        LocalDate date =  Instant.ofEpochMilli(1612144818000L).atZone(zoneOffset).toLocalDate();
        long result = LocalDateTime.of(date, LocalTime.of(0, 0, 0)).toEpochSecond(zoneOffset);
        result *= 1000;
        System.err.println(result);

    }

    private static void putMap(String type,String key, Object value){
        if (!StringUtils.isNoneEmpty(type, key) || Objects.isNull(value)) {
            return;
        }
        String data = big.get(type);

        if (data == null) {
            data = StringUtils.EMPTY;
        }
        Map<String,Object> map = JSONUtils.parseObject(data, Map.class);
        if (CollectionUtils.isEmpty(map)){
            map = new HashMap<>();
        }
        map.put(key,value);

        big.put(type,JSONUtils.toJSONString(map));
    }


    private static Map<String,Object> getFromMap(String key){
        String data = big.get(key);
        if (StringUtils.isNotEmpty(data)) {
            return JSONUtils.parseObject(data,Map.class);
        }
        return null;
    }

}
