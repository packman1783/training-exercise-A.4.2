package org.example.livelock;

import java.util.concurrent.locks.ReentrantLock;

public class LockB {
    public static final ReentrantLock lock1 = new ReentrantLock();
    public static final ReentrantLock lock2 = new ReentrantLock();
}
