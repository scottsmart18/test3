package com.davidniu.thread;
//不安全的取钱
// 两个人同时取钱，可能会导致余额不正确
public class UnSafeBank {

    public static void main(String[] args) {
    // 不安全的银行账户类
        Account account = new Account(1000, "结婚基金");
        Withdraw you = new Withdraw(account, 50, "小明");
        Withdraw girlFriend = new Withdraw(account, 100, "小明的女朋友");

        you.start(); // 小明线程开始取款
        girlFriend.start();// 小明的女朋友线程开始取款
    }

}
//账户
class Account{
    int balance;
    String name;//卡名

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

//银行
class Bank {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    // 存款方法
    public void deposit(int amount) {
        account.balance += amount;
        System.out.println("存款成功，当前余额：" + account.balance);
    }

    // 取款方法
    public void withdraw(int amount) {
        if (account.balance >= amount) {
            account.balance -= amount;
            System.out.println("取款成功，当前余额：" + account.balance);
        } else {
            System.out.println("余额不足，无法取款");
        }
    }
}

//模拟取款
class Withdraw extends Thread {
    private Account account;
    //取了多少钱
    private int drawingAmount;
    //手里有多少钱
    private int currentAmount;

    public Withdraw(Account account, int drawingAmount, String name) {
        super(name);
        this.account = account;
        this.drawingAmount = drawingAmount;
    }

    //synchronized默认锁的是当前对象this,
    @Override
    public void run() {
        //锁变化的量，需要增、删、改的量
        synchronized (account) {
        //判断有没有钱
        if ((account.balance - drawingAmount)< 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }
        try{
            //模拟取钱的延时
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

            //更新余额
            account.balance = account.balance - drawingAmount;
            currentAmount   = currentAmount + drawingAmount;
            System.out.println(this.getName() + "结婚基金余额：" + account.balance);
            System.out.println(Thread.currentThread().getName() + "取款成功，当前余额：" + account.balance);
            System.out.println(this.getName() + "取款成功，手里的钱：" + currentAmount);

        }
    }
}

