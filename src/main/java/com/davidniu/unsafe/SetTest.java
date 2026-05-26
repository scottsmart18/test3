package com.davidniu.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
        public static void main(String[] args) {
            //Set mySet = new HashSet<>();
            //Set mySet = new TreeSet<>();
            //Set mySet = Collections.synchronizedSet(new HashSet<>());
            Set mySet = new CopyOnWriteArraySet<>();

            for (int i = 1; i <= 100; i++) {
                new Thread(() -> {
                    mySet.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(mySet);
                }, String.valueOf(i)).start();

            }

        }
}
