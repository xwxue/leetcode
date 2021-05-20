package com.leetcode.solution.q1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    private final Lock lock = new ReentrantLock();

    private int i = 1;
    private boolean zero = false;

    Condition zeroCondition = lock.newCondition();
    Condition numCondition = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            if(i >= n) {
                zeroCondition.signalAll();
                lock.unlock();
                break;
            }
            if(zero) {
                zeroCondition.await();
            }
            printNumber.accept(0);
            zero = true;
            zeroCondition.signalAll();
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            if(i >= n) {
                numCondition.signalAll();
                zeroCondition.signalAll();
                lock.unlock();
                break;
            }
            if(i % 2 == 1) {
                numCondition.await();
            }
            if(!zero) {
                zeroCondition.await();
            }

            printNumber.accept(i);
            i++;
            zero = false;
            zeroCondition.signal();
            numCondition.signalAll();
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            if(i >= n) {
                numCondition.signalAll();
                zeroCondition.signalAll();
                lock.unlock();
                break;
            }
            if(i % 2 == 0) {
                numCondition.await();
            }
            if(!zero) {
                zeroCondition.await();
            }

            printNumber.accept(i);
            i++;
            zero = false;
            zeroCondition.signal();
            numCondition.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = System.out::print;
        new Thread(()-> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
