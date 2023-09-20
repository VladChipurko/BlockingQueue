package tasks;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String message = queue.take();
				System.out.println("Consumed - " + message);
			}
		} catch (InterruptedException exception) {
			Thread.currentThread().interrupt();
		}

	}

}
