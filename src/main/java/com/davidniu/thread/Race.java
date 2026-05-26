package com.davidniu.thread;
//模拟龟兔赛跑
public class Race implements Runnable {
    private static String winner; // 用于记录获胜者
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i <= 100; i++) {
            if(name.equals("兔子") && i % 10 == 0 && i != 0) {
                // 兔子每跑10步休息1秒
                try {
                    System.out.println(name + "休息了一会儿");
                    Thread.sleep(200); // 模拟兔子休息1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(name + "跑了" + i + "步");
            boolean flag = gameOver(i); // 检查游戏是否结束
            if (flag) {
                break; // 如果游戏结束，退出循环
            }
            try {
                Thread.sleep(100); // 模拟每一步的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "到达终点！");
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true; // 如果已经有获胜者，游戏结束
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName(); // 设置获胜者
            System.out.println("获胜者是：" + winner);
            return true; // 达到终点，游戏结束
        }
        return false; // 游戏继续

    }
    public static void main(String[] args) {
        Race race = new Race();
        Thread thread = new Thread(race, "兔子");
        Thread thread2 = new Thread(race, "乌龟");
        thread.start();
        thread2.start();
    }
}
