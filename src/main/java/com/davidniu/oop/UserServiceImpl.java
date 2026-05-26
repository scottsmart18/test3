package com.davidniu.oop;

public class UserServiceImpl implements Demo07,TimeService{

    @Override
    public void add(int a, int b) {
        System.out.println("添加用户");
    }

    @Override
    public void delete(int i) {
        System.out.println("删除用户");
    }

    @Override
    public void update(int id,String name) {
        System.out.println("更新用户");
    }

    @Override
    public void find(int id) {
        System.out.println("查询用户");
    }

    @Override
    public String getCurrentTime() {
        return "";
    }

    @Override
    public long getCurrentTimestamp() {
        return 0;
    }

    @Override
    public String getCurrentDate() {
        return "";
    }
    /* @Override
    public void doSomething() {
        System.out.println("执行某些操作");
    }
    @Override
    public String getName() {
        return "name";
    }
    @Override
    public int getAge() {
        return 18;
    } */
}
