package com.davidniu.lambda;

public class TestLambda2    {

    public static void main(String[] args) {
        /*class Love implements Ilove {
            @Override
            public void love(int i) {
                System.out.println("I love you! "+i);
            }
        }
        Ilove love = i -> {
                System.out.println("I love you! " + i);
        };*/
        //lambda 表达式简化必须只有一行就可以省略大括号
        // 如果只有一个参数，可以省略括号
        // 多个参数也可以去掉参数类型，要去掉就都去掉，不能只去掉一个参数的类型 必须加上括号
       Ilove love = i -> System.out.println("I love you! " + i); // 使用 Lambda 表达式实现 Ilove 接口
        love.love(520); // 调用 Love 类的 love 方法
  /*
        // 使用匿名内部类实现 Ilove 接口
        Ilove anonymousLove = new Ilove() {
            @Override
            public void love() {
                System.out.println("I love you, too!");
            }
        };
        anonymousLove.love(); // 调用匿名内部类的 love 方法

        // 使用 Lambda 表达式实现 Ilove 接口
        Ilove lambdaLove = () -> System.out.println("I love you, very much!");
        lambdaLove.love(); // 调用 Lambda 表达式的 love 方法
      // 使用 Lambda 表达式创建一个 Runnable 对象
        Runnable runnable = () -> System.out.println("Hello, Lambda!");

        // 启动一个新线程，执行 Runnable 对象
        new Thread(runnable).start();

        // 直接使用 Lambda 表达式作为参数传递
        execute(() -> System.out.println("Executing in a separate thread!"));
    }

    // 接受一个 Runnable 参数的方法
    public static void execute(Runnable task) {
        new Thread(task).start();
    */
    }
}
interface Ilove {
    void love(int i);
}

/*class Love implements Ilove {
    @Override
    public void love(int i) {
        System.out.println("I love you! "+i);
    }
}*/
