package com.example.juc.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketDemo {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 30; i++) {
                    ticket.sale();
                }
            }
        },"AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=  30; i++) {
                    ticket.sale();
                }
            }
        },"BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=  30; i++) {
                    ticket.sale();
                }
            }
        },"CC").start();
    }
}

class Ticket{
    private Integer count=30;
    Lock lock=new ReentrantLock();
    public void sale() {
        //上锁
        lock.lock();
        try {
            if (count>0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第"+(count--)+"\t还剩："+count+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
