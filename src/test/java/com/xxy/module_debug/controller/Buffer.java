package com.xxy.module_debug.controller;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    final ReentrantLock lock = new ReentrantLock();
    final Condition unFull = lock.newCondition();
    final Condition unEmpty = lock.newCondition();

    Queue<Object> queue = new ArrayDeque<>(5);

    public void put(Object x){

        lock.lock();
        try {
            while (queue.size() == 5)
                unEmpty.await();
            queue.add(x);
            unFull.signal();

            System.out.println(Thread.currentThread().getName() + " put  "+ x+"queue size"+queue.size());
        }catch (Exception e){
            System.err.println(e);
        }finally {
            lock.unlock();
        }

    }

    public Object take(){

        lock.lock();
        try {
            while (queue.size() == 0)
                unFull.await();
            Object x = queue.poll();
            unEmpty.signal();
            System.out.println(Thread.currentThread().getName() + " take "+ x);
            return x;
        }catch (Exception e){
            System.err.println(e);
        }finally {
            lock.unlock();
        }
        return null;
    }

}
