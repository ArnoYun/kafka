package org.example;


import org.apache.kafka.clients.producer.Producer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread.sleep(5000);

        Thread2 thread2 = new Thread2();
        thread2.start();

    }
}

class Thread1 extends Thread{
    public void run(){
        Consumer_class.createConsumer("TESTtopic", "TESTtopic2", 2);
    }
}

class Thread2 extends Thread{
    public void run(){
        Producer<String, String> producer1 = Producer_class.createProducer(1);
        for(int i = 1; i <= 10; i++ ) {
            Producer_class.sendMessage(producer1, "TESTtopic", "MESSAGE_____________________" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        producer1.close();
    }
}