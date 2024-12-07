package com.littlebee.mysemaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            final int threadNumber = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadNumber + " trying to acquire semaphore");
                    System.out.println("Thread " + threadNumber + "Available semaphore: " + semaphore.availablePermits() + " before acquire.");
                    semaphore.acquire();
                    System.out.println("Thread " + threadNumber + "Available semaphore: " + semaphore.availablePermits() + " after acquire.");
                    System.out.println("Thread " + threadNumber + " acquired semaphore");
                    Thread.sleep(1000); // simulate task execution
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("Thread " + threadNumber + " release semaphore");
                    semaphore.release();
                }
            }).start();
        }
    }
}
