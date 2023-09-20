package tasks;
import java.util.concurrent.BlockingQueue;

public class Produser implements Runnable {
	
	private final BlockingQueue<String> queue;
	
	public Produser(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				String message = "Message " + i;
				queue.put(message);
				System.out.println(message);
				Thread.sleep(1000);
			}
		} catch (InterruptedException exception) {
			Thread.currentThread().interrupt();
		}

	}

}
