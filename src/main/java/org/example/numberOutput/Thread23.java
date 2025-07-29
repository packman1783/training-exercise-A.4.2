package org.example.numberOutput;

import static org.example.numberOutput.LockC.isOneTurn;
import static org.example.numberOutput.LockC.lock;

public class Thread23 extends Thread {
    public void run() {
        while (true) {
            synchronized (lock) {
                while (isOneTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("2");
                isOneTurn = true;
                lock.notifyAll();
            }
        }
    }
}
