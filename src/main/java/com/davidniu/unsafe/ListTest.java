package com.davidniu.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
        public static void main(String[] args) {
            //List myList = Arrays.asList("1","2","3");
            //myList.forEach(System.out::println);
            //List<String> myList = new ArrayList<>();
            //List<String> myList = new Vector<>();
            //List<String> myList = Collections.synchronizedList(new ArrayList<>());
            List<String> myList = new CopyOnWriteArrayList<>();

           for (int i = 1; i <= 100; i++) {
                new Thread(() -> {
                     myList.add(UUID.randomUUID().toString().substring(0,5));
                     System.out.println(myList);
                }, String.valueOf(i)).start();

           }

        }
}
