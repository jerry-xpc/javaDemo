package com.java.javaSE.thread.blockingqueue.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {
 
	public static void main(String[] args) {
		
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3,true);
		Producer producerPut = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		new Thread(producerPut).start();
		new Thread(consumer).start();
	}
}