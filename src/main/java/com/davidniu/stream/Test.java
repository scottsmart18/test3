package com.davidniu.stream;

import java.util.Arrays;
import java.util.List;
/*
* 题目：请按照给出数据，找出同时满足以下条件的用户
* 也即以下条件：
* 1、全部满足偶数ID
* 2、年龄大于24
* 3、用户名转为大写
* 4、用户名字母倒排序
* 5、只输出一个用户名字 limit
**/
public class Test {
        public static void main(String[] args) {
            User user1 = new User(1,"a", 18);
            User user2 = new User(2,"b", 19);
            User user3 = new User(3,"c", 20);
            User user4 = new User(4,"d", 21);
            User user5 = new User(6,"e", 22);
            List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
            list.forEach(System.out::println);
                list.stream()
                        .filter(user -> user.getId() % 2 == 0)
                        .filter(user -> user.getAge() > 20)
                        .map(user -> user.getName().toUpperCase())
                        .sorted((s1, s2) -> s2.compareTo(s1))
                        .limit(1)
                        .forEach(System.out::println);
        }
}
