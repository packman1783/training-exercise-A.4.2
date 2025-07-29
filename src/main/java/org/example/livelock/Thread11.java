package org.example.livelock;

import java.util.concurrent.TimeUnit;

public class Thread11 extends Thread {
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + ": attempting to capture the object monitor lock1");
                if (LockB.lock1.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + ": object lock1 monitor captured");
                    Thread.sleep(100);

                    System.out.println(Thread.currentThread().getName() + ": attempting to capture the object monitor lock2");
                    if (LockB.lock2.tryLock(50, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": object lock1 lock2 monitor captured");
                            break;
                        } finally {
                            System.out.println(Thread.currentThread().getName() + ": object lock2 released");
                            LockB.lock2.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": object lock2 monitor not captured lock1 released");
                        LockB.lock1.unlock();
                    }
                }
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
