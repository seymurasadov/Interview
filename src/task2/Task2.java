package task2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Task2 {
	public static void main(String[] args) {
//		2. Write 2 types of streams:
//			1) generates a random number once per second
//			2) receives a number as input, prints it and the time of receipt
//			   Write a program that launches from 1 to 5 streams of each 
//			   type, organize data transfer between streams of types 1 
//			   and 2, taking into account that there can be a random
//			   number of them on each side. The flow time can be limited 
//			   to 30 seconds.
		
		Stream<Integer> stream = Stream.generate(() -> {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				return ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
			});
		
		stream.forEach(System.out::println);
		
		

	}
}
