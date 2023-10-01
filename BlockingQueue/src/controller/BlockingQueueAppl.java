package controller;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import tasks.Consumer;
import tasks.Produser;

public class BlockingQueueAppl {

	private static final int PROD_NUMS = 10;

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		Thread[] arr = new Thread[PROD_NUMS];
		
		for (int i = 0; i < PROD_NUMS; i++) {
			arr[i] = new Thread(new Produser(queue, i));
			arr[i].start();
		}
		
		//Thread produserThread = new Thread(new Produser(queue));
		Thread consumerThread = new Thread(new Consumer(queue));
		
		consumerThread.setDaemon(true);
		
		//produserThread.start();
		consumerThread.start();

	}

}
