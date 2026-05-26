package com.davidniu.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test08 {
        public static void main(String[] args)  {
            try {
                Method method1 = Test08.class.getMethod("test01", Map.class, List.class);
                Type[] genericParameterTypes = method1.getGenericParameterTypes();
                for (Type genericParameterType : genericParameterTypes) {
                    System.out.println(genericParameterType);
                    if(genericParameterType instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                        for (Type actualTypeArgument : actualTypeArguments) {
                            System.out.println("泛型参数类型：" + actualTypeArgument);
                        }
                    }
                }
                Method method2 = Test08.class.getMethod("test02", null);
                Type genericReturnType = method2.getGenericReturnType();
                System.out.println(genericReturnType);
                    if(genericReturnType instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                        for (Type actualTypeArgument : actualTypeArguments) {
                            System.out.println("泛型返回类型：" + actualTypeArgument);
                        }
                    }
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            //Test08.class.getMethod("test02",null   );
        }

        public void test01(Map<String, User> map, List<User> list)  {
            System.out.println("test01 方法被调用");
        }

        public Map<String,User> test02() {
            System.out.println("test02 方法被调用");
            return null;
        }
}
