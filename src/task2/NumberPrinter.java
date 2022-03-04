package task2;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

class NumberPrinter implements Runnable {

	private static int lastPrintedNumber = 0;
	private LocalDateTime deadline;
	
	public NumberPrinter(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	@Override
	public void run() {
		while (deadline.isAfter(LocalDateTime.now())) {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (NumberPrinter.class) {
				if (Task2.number.get() != lastPrintedNumber) {
					System.out.println(
							Thread.currentThread().getName()+
							" Number " + Task2.number.get()+
							" Time " + LocalDateTime.now());
					lastPrintedNumber = Task2.number.get();
				}
			}
		}
		
		Thread.currentThread().interrupt();

	}

}