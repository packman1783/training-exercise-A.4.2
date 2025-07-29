package org.example;

import org.example.deadlock.Thread10;
import org.example.deadlock.Thread20;
import org.example.livelock.Thread11;
import org.example.livelock.Thread22;
import org.example.numberOutput.Thread12;
import org.example.numberOutput.Thread23;

public class Main {
    public static void main(String[] args) {
//        Thread10 thread10 = new Thread10();
//        Thread20 thread20 = new Thread20();
//        thread10.start();
//        thread20.start();
//
//        Thread11 thread11 = new Thread11();
//        Thread22 thread22 = new Thread22();
//        thread11.start();
//        thread22.start();

        Thread12 thread12 = new Thread12();
        Thread23 thread23 = new Thread23();
        thread12.start();
        thread23.start();
    }
}