package com.java.javaSE.thread.blockingqueue.LinkedBlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainClass {
 
	public static void main(String[] args) {
		
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
		Producer producerPut = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		new Thread(producerPut).start();
		new Thread(consumer).start();
	}
}