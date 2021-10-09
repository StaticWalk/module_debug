package com.xxy.module_debug.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main11 {

    static class Shop {
        public Shop(String product,int rank) {
            this.product = product;
            this.rank = rank;
        }

        String product;
        int rank;

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

//        public Future<Double> getPriceAsync(String product) {

//            CompletableFuture<Double> future = new CompletableFuture<>();
//            new Thread(() ->{
//                try{
//                    double price = calculatePrice(product);
//                    future.complete(price);
//                }catch (Exception e){
//                    future.completeExceptionally(e);
//                }
//            }).start();
//            return future;

//            return  CompletableFuture.supplyAsync(() -> calculatePrice(product));

//        }
//        private double calculatePrice(String product) {
//            delay();
//            return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
//        }
//
//        public List<String> findPrices(String product) {
//            return shops.stream()
//                    .map(shop -> String.format("%s price is %.2f",
//                            shop.getName(), shop.getPrice(product)))
//                    .collect(toList());
//        }
//
//        public double getPrice(String product) {
//            return calculatePrice(product);
//        }
//        private double calculatePrice(String product) {
//            delay();
//            return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
//        }
//
//    }

    private <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


    static Buffer buffer = new Buffer();

    static class PutThread extends Thread{
        private int num;
        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }
        public void run() {
            try {
                Thread.sleep(1);    // 线程休眠1ms
                buffer.put(num);        // 向BoundedBuffer中写入数据
            } catch (InterruptedException e) {
            }
        }
    }

    static class TakeThread extends Thread{
        private int num;
        public TakeThread(String name) {
            super(name);
            this.num = num;
        }
        public void run() {
            try {
                Thread.sleep(10);    // 线程休眠1ms
                buffer.take();        // 向BoundedBuffer中写入数据
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {


        // 启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从BoundedBuffer中不断的读数据。
//        for (int i=0; i<10; i++) {
//            new PutThread("p"+i, i).start();
//            new TakeThread("t"+i).start();
//        }
//         ZoneOffset zoneOffset = ZoneOffset.of("+8");
//
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//
//        long x = LocalDateTime.parse("2021-01-11 17:33:00",formatter).toInstant(zoneOffset).toEpochMilli();

        System.err.println(String.format("%s_%s","ssa",null));



//        List<Shop> shops = Arrays.asList(new Shop("四川",2),
//                new Shop("成都",2),
//                new Shop("北京",1),
//                new Shop("广州",3));
//
//        Collections.shuffle(shops);
//        Main11 main11 = new Main11();
//
//        shops = shops.stream()
//                .filter(main11.distinctByKey(shop -> shop.rank))
//                .sorted(Comparator.comparingInt(o -> o.rank))
//                .collect(Collectors.toList());



        //迭代器 remove
//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        System.err.println(shops);

//        for (Integer x : list){
//            if (x  == 3){
//                System.err.println(x);
//                list.remove(x);
//            }
//        }
//        Integer x = 4;
//
//        list.remove(x);

//        list(0,4);

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            int x = iterator.next();
//            if (x == 3){
//                System.err.println(x);
//                iterator.remove();
//            }
//        }

//        list = list.stream().filter(integer -> integer>2).collect(Collectors.toList());
//        System.out.println(555);


    }
}
