package task2;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class NumberGenerator implements Runnable{
	
	private LocalDateTime deadline;
	
	public NumberGenerator(LocalDateTime deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public void run() {
		while(deadline.isAfter(LocalDateTime.now())) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			Task2.number.set(ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE));

		}
		
		Thread.currentThread().interrupt();
	}


}
