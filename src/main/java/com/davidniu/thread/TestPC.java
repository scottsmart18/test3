package com.davidniu.thread;
//测试生产者消费者模型，利用缓冲区解决：管程法
//生产者、消费者、缓冲区、产品
public class TestPC {
    public static void main(String[] args) {
        Buffer b = new Buffer(100); // 创建缓冲区，容量为100
        // 创建生产者和消费者对象
        Producer producer = new Producer(b);
        Consumer consumer = new Consumer(b);

        // 启动生产者线程
        Thread producerThread = new Thread(producer);
        producerThread.start();

        // 启动消费者线程
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}
//生产者
class Producer extends Thread {
    Buffer buffer;  // 创建缓冲区

    public Producer( Buffer buffer) {
        this.buffer = buffer; // 初始化缓冲区
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { // 生产100个产品
            try {
                Chicken chicken = new Chicken(i);
                buffer.produce(chicken); // 生产产品
                Thread.sleep(100); // 模拟生产时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Consumer extends Thread {
    Buffer buffer;  // 创建缓冲区

    public Consumer(Buffer buffer) {
        this.buffer = buffer; // 初始化缓冲区
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { // 消费100个产品
            try {
                Chicken chicken = buffer.consume(); // 消费产品
                //System.out.println("消费了第: " + chicken.getId() + " 只鸡");
                Thread.sleep(200); // 模拟消费时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//产品 鸡
class Chicken {
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}

//缓冲区
class Buffer {
    private Chicken[] chickens = new Chicken[10]; // 缓冲区数组
    private int count=0; // 当前缓冲区中的产品数量
    private int capacity; // 缓冲区的容量

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.chickens = new Chicken[capacity];
        this.count = 0;
    }

    // 生产者方法：添加产品到缓冲区
    public synchronized void produce(Chicken chicken) throws InterruptedException {
        while (count == capacity) { // 缓冲区满，等待
            wait();
        }
        chickens[count++] = chicken; // 添加产品
        System.out.println("生产者生产了第: " + chicken.getId() + " 只鸡");
        notifyAll(); // 通知消费者线程
    }

    // 消费者方法：从缓冲区获取产品
    public synchronized Chicken consume() throws InterruptedException {
        while (count == 0) { // 缓冲区空，等待
            wait();
        }
        Chicken chicken = chickens[--count]; // 获取产品
        System.out.println("消费者消费了第: " + chicken.getId() + " 只鸡");
        notifyAll(); // 通知生产者线程
        return chicken;
    }
}
