package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread{
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public PassengerThread(String name, Semaphore semaphore, CountDownLatch countDownLatch) {
        super(name);
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        try {
            System.out.println(this.getName() + " Пассажир пришел на кассу ");
            semaphore.acquire();
            System.out.println(this.getName() + " Пассажир покупает билет ");
            sleep(2000);
            System.out.println(this.getName() + " Пассажир купил билет ");
            semaphore.release();
            countDownLatch.countDown();
            countDownLatch.await();
        } catch (Exception e){
            System.out.println(this.getName() + " Пассажир не пришел на кассу ");
        }


    }
}
