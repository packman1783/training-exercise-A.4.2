package org.example.deadlock;

public class Thread20 extends Thread{
    public void run() {
        System.out.println(Thread.currentThread().getName() +  ": attempting to capture the object monitor lock2");

        synchronized (LockA.lock2) {
            System.out.println(Thread.currentThread().getName() + ": object lock2 monitor captured.");
            try { Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": attempting to capture the object monitor lock1...");

            synchronized(LockA.lock1) {
                System.out.println(Thread.currentThread().getName() + ": object lock1 monitor captured.");
            }
        }
    }
}
