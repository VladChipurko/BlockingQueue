package controller;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import tasks.Consumer;
import tasks.Produser;

public class BlockingQueueAppl {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		Thread produserThread = new Thread(new Produser(queue));
		Thread consumerThread = new Thread(new Consumer(queue));
		
		consumerThread.setDaemon(true);
		
		produserThread.start();
		consumerThread.start();

	}

}
