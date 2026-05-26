package com.davidniu.function;

import java.util.function.Supplier;

public class Demo04 {
            public static void main(String[] args){
                    Supplier supplier = new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        return 1024;
                    }
                };
        Supplier<Integer> supplier2 = () -> 1025;
        System.out.println(supplier.get());
        System.out.println(supplier2.get());

           }
}
