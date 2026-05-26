package com.davidniu.function;

import java.util.function.Function;

public class Demo01 {
        public static void main(String[] args) {
            /*Function function = new Function<String,String>() {
                        @Override
                        public String apply(String s) {
                            return s;
                        }
                    };*/
                Function<String,String> function = s -> s;
            System.out.println(function.apply("hello"));
                    ;

        }
}
