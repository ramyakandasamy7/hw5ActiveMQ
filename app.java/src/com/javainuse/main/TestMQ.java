package com.javainuse.main;

import com.javainuse.consumer.Consumer;
import com.javainuse.producer.Producer;

public class TestMQ {

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
 
        Thread producerThread = new Thread(producer);
        producerThread.start();
 
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}