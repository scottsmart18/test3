package com.davidniu.function;

import java.util.function.Predicate;

public class Demo02 {
        public static void main(String[] args) {
            Predicate<String> p = new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return s.isEmpty();
                }
            };
             Predicate<String> p2 = s -> s.isEmpty();
             System.out.println(p.test("hello"));
             System.out.println(p2.test("hello world"));
        }
}
