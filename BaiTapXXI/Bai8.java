package BaiTapXXI;

import java.util.concurrent.atomic.AtomicInteger;

public class Bai8 {
    public static void main(String[] args) {
        AtomicInteger number = new AtomicInteger();
        Thread thread1 = new Thread(() -> {
            while (true) {
                number.getAndIncrement();
                System.out.println("Thread 1: " + number);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                number.getAndDecrement();
                System.out.println("Thread 2: " + number);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}