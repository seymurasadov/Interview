package task2;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {
	public static AtomicInteger number = new AtomicInteger(0);

	public static void main(String[] args) {

		int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 6);

		for (int i = 0; i < randomNumber1; i++) {
			
			new Thread(new NumberGenerator(LocalDateTime.now().plusSeconds(30))).start();
		}

		int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 6);
		
		for(int i = 0; i < randomNumber2; i++) {
			new Thread(new NumberPrinter(LocalDateTime.now().plusSeconds(30))).start();
		}

	}
}
