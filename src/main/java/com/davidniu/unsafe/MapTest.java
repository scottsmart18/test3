package com.davidniu.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
        public static void main(String[] args) {
            //Map myMap = new HashMap<>();
            //Map myMap = new TreeMap<>();
            //Map myMap = Collections.synchronizedMap(new HashMap<>());
            Map myMap = new ConcurrentHashMap<>();

            for (int i = 1; i <= 100; i++) {
                final int tempInt = i;
                new Thread(() -> {
                    myMap.put(tempInt, UUID.randomUUID().toString().substring(0,5));
                    System.out.println(myMap);
                }, String.valueOf(i)).start();

            }

        }
}
