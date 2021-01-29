package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4, true);
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 1; i < 101; i++) {
            new PassengerThread("Пассажир " + i, semaphore, countDownLatch).start();

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Автобус заполнен и отправляется в город Ош");
    }
}
